package com.feivirus.ruleValidator.enums;


/**
 * 报价方式类型
 * @author feivirus
 *
 */
public enum QuoteTypeEnum {
	//自动报价
	AUTOMATIC_QUOTE(0),
	
	//人工报价
	MANUAL_QUOTE(1),
	
	//自动&人工报价
	AUTOMATIC_MANUAL_QUOTE(2);
	
	private Integer value;
	
	private QuoteTypeEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static QuoteTypeEnum getQuoteTypeEnum(Integer value) {
		if (value != null) {
			for(QuoteTypeEnum quoteType : QuoteTypeEnum.values()) {
				if (quoteType.getValue() == value.intValue()) {
					return quoteType;
				}
			}
		}
		return null;
	}
}
