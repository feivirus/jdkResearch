package com.feivirus.instruction.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author feivirus
 *
 */
public enum OperatorEnum {
	EQ("eq", "等于"),
	
	NEQ("neq", "不等于"),	
	
	GT("gt", "大于"),
	
	EGT("egt", "等于等于"),
	
	LT("lt", "小于"),
	
	ELT("elt", "小于等于"),
	
	IN("in", "包含"),
	
	NOT_IN("not_in", "不包含"),
	
	BETWEEN("between", "范围是"),
	
	NOT_BETWEEN("not_between", "范围不是"),
	
	PLUS("add", "加"),
	
	MINUS("minus", "减"),
	
	MULTIPLY("multiply", "乘"),
			
	DEVIDED("devided", "除");
	
	private final String code;
	
	private final String name;	

	OperatorEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}	
	
	public static OperatorEnum getEnumByCode(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		
		for(OperatorEnum enumItem : OperatorEnum.values()) {
			if (enumItem.getCode().equalsIgnoreCase(value)) {
				return enumItem;
			}
		}
		
		return null;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}	
}
