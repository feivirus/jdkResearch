package com.feivirus.fastjson;

import com.alibaba.fastjson.JSONObject;

public class FastJson {
	Order order = new Order();
	
	order.setOrderId(1);
	
	JSONObject jsonObject = new JSONObject();
	String jsonStr = jsonObject.toJSONString(order);
	
	Order newOrder = (Order) jsonObject.parse(jsonStr);
	
}
