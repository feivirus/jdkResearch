package com.feivirus.hadoop.config;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

public class HadoopConfiguration {

    public FileSystem initFileSystem() {
        Configuration config = new Configuration();

        config.set("fs.defaultFS", "hdfs://127.0.0.1:8020");
        try {
            FileSystem fs = FileSystem.get(config);
            return fs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HadoopConfiguration connection = new HadoopConfiguration();

        FileSystem fs = connection.initFileSystem();
        System.out.println(fs);
    }

}
