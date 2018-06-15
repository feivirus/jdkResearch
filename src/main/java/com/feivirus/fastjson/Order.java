package com.feivirus.fastjson;

import java.io.Serializable;

/**
 * Serializable已经渐渐不用了，以后都用json
 * 最早没有json，如果要存储的话，都是存储到文件中，
 * 如果要存储一个对象(多个属性)，每个人都有自己的一套存储标准，往文件里写对象，但是每个人的标准不统一，oracle就定义了Serializable，定了一套存储标准
 *
 * 关于serialVersionUID：如果你没有手动写这样一个serialVersionUID，那么java会自动给你生成一个默认的xxx，
 * 当你写对象A到文件中后（此时序列号为xxx），又对A对象增加了一个成员变量，那么java会又生成了一个默认的yyy
 * 此时从文件中读对象A时，因为xxx!=yyy，就会报错
 * 所以一般自己手动加上serialVersionUID（IDE会提示你生成一个随机数）
 *
 * 同时需要注意，持久化的数据均为存在于堆中的数据，static类型的数据存在于方法区中，不能被持久化。
 * 如果想不持久化某个成员变量，则需要在成员变量加上关键字@Transient (譬如一个对象中，有一个属性，不需要落库，只用来做中转temp用)
 *
 * https://blog.csdn.net/leixingbang1989/article/details/50556966
 *
 * 
 *
 */
public class Order /*implements Serializable*/{
	//private static final long serialVersionUID = -8859324123344372618L;
	private Integer orderId;
	
	private String orderNo;
	
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
