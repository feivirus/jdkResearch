package com.feivirus.hadoop.order;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 * 产品订单信息
 * @author feivirus
 *
 */
public class ProdOrderInfo implements Writable, Cloneable{
    
    private Integer orderId;
    
    private String date;
    
    //产品编号
    private String prodNo;
    
    private Integer amount;
    
    private String prodName;
    
    private int categoryId;
    
    private double price;
    
    //0 订单 1 产品
    private String flag;    

    @Override
    public void write(DataOutput out) throws IOException {
       out.writeInt(orderId);
       out.writeUTF(date);
       out.writeUTF(prodNo);
       out.writeInt(amount);
       out.writeUTF(prodName);
       out.writeInt(categoryId);
       out.writeDouble(price);
       out.writeUTF(flag);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
       orderId = in.readInt();
       date = in.readUTF();
       prodNo = in.readUTF();
       amount = in.readInt();
       prodName = in.readUTF();
       categoryId = in.readInt();
       price = in.readDouble();
       flag = in.readUTF();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {    
        return super.clone();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }    
}
