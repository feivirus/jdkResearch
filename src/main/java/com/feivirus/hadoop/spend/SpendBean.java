package com.feivirus.hadoop.spend;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

/**
 * 
 * @author feivirus
 *
 */
public class SpendBean implements WritableComparable<SpendBean> {
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
        userName.write(out);
        address.write(out);
        bizType.write(out);
        money.write(out);
    }    

    @Override
    public int compareTo(SpendBean o) {      
        return o.getMoney().get() - this.getMoney().get();
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        if (userName == null) {
            userName = new Text();            
        }
        if (address == null) {
            address = new Text();
        }
        if(bizType == null) {
            bizType = new Text();
        }
        if (money == null) {
            money = new IntWritable();
        }
        userName.readFields(in);
        address.readFields(in);
        bizType.readFields(in);
        money.readFields(in);
    }

    public Text getUserName() {
        return userName;
    }

    public void setUserName(Text userName) {
        this.userName = userName;
    }

    public Text getAddress() {
        return address;
    }

    public void setAddress(Text address) {
        this.address = address;
    }

    public Text getBizType() {
        return bizType;
    }

    public void setBizType(Text bizType) {
        this.bizType = bizType;
    }

    public IntWritable getMoney() {
        return money;
    }

    public void setMoney(IntWritable money) {
        this.money = money;
    }             
}
