package com.feivirus.ruleValidator.base.annotation;

import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public enum RuleConditionCheckerType {
	//字符串校验 
	//StringRuleCondition
	STRING_CHECKER(0),
	
	//整数校验
	//IntegerRuleCondition
	INTEGER_CHECKER(1),
	
	//区间对象校验
	VALUE_SCOPE_CHECKER(2),
	
	//日期格式校验
	//DateValueRangeRuleCondition
	DATE_VALUE_RANGE_CHECKER(3),
	
	//Double形式的区间的list检验
	//DoubleValueRangeListRuleCondition
	DOUBLE_VALUE_RANGE_LIST_CHECKER(4),
	
	//Double形式的区间检验
	//DoubleValueRangeRuleCondition
	DOUBLE_VALUE_RANGE_CHECKER(5),
	
	//String的list校验
	STRING_LIST_CHECKER(6),
	
	//SysAreaDTO的list地区校验
	SYS_AREA_LIST_CHECKER(7),
	
	//Integer形式的区间校验
	INTEGER_VALUE_RANGE_CHECKER(8),
	
	//Boolean形式的区间校验
	BOOLEAN_CHECKER(9),
	
	//String形式的List表示日期
	DATE_STRING_LIST_CHECKER(10),
	
	//Integer形式的List校验
	INTEGER_LIST_CHECKER(11),
	
	//Integer形式的ValueRange的List校验
	INTEGER_VALUE_RANGE_LIST_CHECKER(12);
	
	private int value;
	
	RuleConditionCheckerType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static RuleConditionCheckerType getRuleConditionCheckerEnum(Integer param) {
		if (param != null) {
			for(RuleConditionCheckerType checkerEnum : RuleConditionCheckerType.values()) {
				if (checkerEnum.getValue() == param.intValue()) {
					return checkerEnum;
				}
			}
		}
		return null;
	}
	
	
}
