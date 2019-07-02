package com.feivirus.hadoop.spend;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

/**
 * 
 * @author feivirus
 *
 */
public class SpendBean implements Writable {
    private Text userName;
    
    private Text address;
    
    private Text bizType;
    
    private IntWritable money;
    
    public SpendBean() {
    }
    
    public SpendBean(Text userName, IntWritable money) {
        this.userName = userName;
        this.money = money;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        
    }     
}
