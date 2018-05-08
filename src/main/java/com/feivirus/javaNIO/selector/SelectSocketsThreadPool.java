package com.feivirus.javaNIO.selector;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author feivirus
 *
 */
public class SelectSocketsThreadPool extends SelectSockets{
	private static final int MAX_THREADS = 5;
	private ThreadPool pool = new ThreadPool(MAX_THREADS);
	
	public static void main(String[] args) throws IOException {
		new SelectSocketsThreadPool().run(args);
	}
	
	private class ThreadPool {
		List idle = new LinkedList();
		
		ThreadPool(int poolSize) {
			for(int i = 0; i < poolSize; i++) { 
				WorkerThread thread = new WorkerThread(this);
				
				thread.setName("Worker" + (i + 1));
				thread.start();
				idle.add(thread);
			}	
		}	
		
		WorkerThread getWorker() {
			WorkerThread worker = null;
			
			synchronized(idle) {
				if (idle.size() > 0) {
					worker = (WorkerThread) idle.remove(0);
				}
			}
			return worker;
		}
		
		void collectWorker(WorkerThread worker) {
			synchronized (idle) {
				idle.add(worker);
			}
		}
	}	
	private class WorkerThread extends Thread {
		private ByteBuffer buffer = ByteBuffer.allocate(1024);
		private ThreadPool pool;
		private SelectionKey key;
		
		public WorkerThread(ThreadPool pool) {
			this.pool = pool;
		}
		
		//下面用到了公共的pool，所以synchronized
		public synchronized void run() {
			System.out.println(this.getName() + " is ready");
			while (true) {
				try {
					this.wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
					this.interrupted();
				}
				
				if (key == null) {
					continue;
				}
				
				System.out.println(this.getName() +  " has been awakened");
				
				try {
					drainChannel(key);
				} catch (IOException ex) {
					System.out.println("Caught '" + ex + "' cloing channel");
					try {
						key.channel().close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					key.selector().wakeup();
				}
				
				key = null;
				this.pool.collectWorker(this);
			}			
		}
		
		void drainChannel(SelectionKey key) throws IOException {
			SocketChannel channel = (SocketChannel) key.channel();
			int count;
			
			buffer.clear();
			
			while ((count = channel.read(buffer)) > 0) {
				buffer.flip();
				
				while (buffer.hasRemaining()) {					
					System.out.println(buffer.get());
				}
				//正常业务逻辑在这
				
				buffer.clear();
			}
			
			if (count < 0) {
				channel.close();
				return;
			}
			
			//处理完，恢复接收新请求，
			key.interestOps(key.interestOps() | SelectionKey.OP_READ);
			
			key.selector().wakeup();
		}
		
		void serviceChannel(SelectionKey key) {
			this.key = key;
			//当前正在处理上一个客户端的发来数据，取消读操作请求，只有当前请求处理完，再恢复接收请求操作.
			key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
			synchronized(this) {
				this.notifyAll();
			}			
		}
	}
	
	protected void readDataFromSocket(SelectionKey key) throws IOException {
		WorkerThread worker = pool.getWorker();
		
		if (worker == null) {
			return;
		}
		
		worker.serviceChannel(key);
	}
}
