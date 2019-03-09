package com.feivirus.commonclass;

import lombok.Data;

public class ConditionOperator {
	public static void main(String []args) {
	    Integer count = 1;
	    Long lCount = 124l;
	    Object count2 = (Object) count;
	    String str = "Hello World";
	    
		Customer customer = null;
		
		UserCarInfoTmp userCarinfoTmp = new UserCarInfoTmp();
		
		//1.
		Short shortParam = null;
		
		Integer carSeatNum = (customer != null && customer.getSeatNum() != null) ? customer.getSeatNum()
                 : userCarinfoTmp.getSeatNum();
		
		System.out.println("shit 1 " + carSeatNum);
		
		//2.
		Integer carSeatNum1 = userCarinfoTmp.getSeatNum();
		
		System.out.println("shit 2 " + carSeatNum);
		
		
		
		//Integer result = shortParam;
		
	}
}


class Customer{
	private Short seatNum;

	public Short getSeatNum() {
		return seatNum;
	}	
}


class UserCarInfoTmp {
	private Integer seatNum;

	public Integer getSeatNum() {
		return seatNum;
	}
}
