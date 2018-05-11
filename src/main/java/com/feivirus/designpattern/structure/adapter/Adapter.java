package com.feivirus.designpattern.structure.adapter;

/**
 * 
 * @author feivirus
 * 参考链接
 * https://www.ibm.com/developerworks/cn/java/j-lo-adapter-pattern/
 */
public class Adapter {
	public static void main(String[] args) {
		Log fileLog = new Log();		
		LogFileApi logFileApi = new LogFileImpl();
		
		LogDBApi logDBApi = new LogAdapter(logFileApi);
		logDBApi.createLog(fileLog);
		
	}
}
