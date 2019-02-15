package com.feivirus.caculator;

import org.apache.commons.lang.StringUtils;

public enum CaculatorOperatorEnum {
	ADD("add", "加"),
	
	MINUS("minus", "减"),
	
    MULTIPLY("multiply", "乘"),
    
    DIVIDE("divide", "除");
	
	private String code;
	
	private String name;
	
	private CaculatorOperatorEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static  CaculatorOperatorEnum getEnum(String code) {
			if (StringUtils.isEmpty(code)) {
				return null;
			}
			
			for (CaculatorOperatorEnum enumElement : CaculatorOperatorEnum.values()) {
				if (enumElement.getCode().equals(code)) {
					return enumElement;
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
