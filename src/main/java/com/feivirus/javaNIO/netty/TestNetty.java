package com.feivirus.javaNIO.netty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.commons.codec.binary.Hex;

public class TestNetty {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 1077));

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        //for(int i = 0; i < 30; i ++) {
            FileReader fileReader = new FileReader("media_mock_1.log");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] hexs = line.split("hex=");

                outputStream.write(0x7e);
                //outputStream.write(Hex.decode(hexs[1].trim()));
                outputStream.write(0x7e);
                outputStream.flush();
                Thread.currentThread().sleep(50);

            }
            outputStream.flush();

            //Thread.currentThread().sleep(50);
        //}

        Thread.currentThread().sleep(60000);
        socket.close();
    }  
    
}
