package com.feivirus.hadoop.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.io.IOUtils;

import com.feivirus.hadoop.config.HadoopConfiguration;

/**
 * hdfs操作的接口
 * https://www.cnblogs.com/zhuxiaojie/p/7384677.html
 * @author feivirus
 *
 */
public class HDFSOperation {
    private HadoopConfiguration configuration;

    private FileSystem fs;

    public void init() {
        if (configuration == null) {
            configuration = new HadoopConfiguration();
        }
        if (fs == null && configuration != null) {
            fs = configuration.initFileSystem();
        }
    }
    
    public void upload() {
        try {
            FSDataOutputStream outputStream = fs.create(new Path("/wordcountdemo/input/wc2.input"), true);
            InputStream inputStream = new FileInputStream("/Users/feivirus/Documents/software/hadoop/my_data/wc.input");
            IOUtils.copyBytes(inputStream, outputStream, 1024, true);
        } catch (IllegalArgumentException e) {        
            e.printStackTrace();
        } catch (IOException e) {       
            e.printStackTrace();
        }        
    }
    
    public void download() {
        try {
            FSDataInputStream inputStream = fs.open(new Path("/wordcountdemo/input/wc2.input"));
            inputStream.seek(5);
            OutputStream outputStream = new FileOutputStream(new File("/Users/feivirus/Desktop/wc2.input"));
            IOUtils.copyBytes(inputStream, outputStream, 1024, true);
            
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public void showConf() {
        Iterator<Entry<String, String>> iterator = fs.getConf().iterator();
        
        while (iterator.hasNext()) {
            Entry<String, String> entry =iterator.next();
            
            System.out.println(entry);            
        }
    }
    
    public void listFiles(String path) {
        try {
            RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path(path), true);
            
            while (listFiles.hasNext()) {
                LocatedFileStatus fileStatus = listFiles.next();
                
                System.out.println("one file:");
                System.out.println("path" + fileStatus.getPath());
                System.out.println("block size" + fileStatus.getBlockSize());                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public static void main(String[] args) {
        HDFSOperation hdfs = new HDFSOperation();
        
        hdfs.init();
        //hdfs.upload();
        //hdfs.download();
        //hdfs.showConf();
        hdfs.listFiles("/");
    }

}
