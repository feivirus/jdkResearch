package com.feivirus.rule.base.checker;

import com.feivirus.rule.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class NumberConditionChecker {
	public  static <T extends Number> RuleRelationEnum compare(T src, T target) {
		//前端可能传-1代表没有值，和null一样
		if (src != null && target != null && src.doubleValue() != -1 && target.doubleValue() != -1) {
			return RuleRelationEnum.SEPARATE;
		}		
		if (src == null && target == null) {
			return RuleRelationEnum.UNKNOWN;
		}
		if (src == null && target != null) {
			return RuleRelationEnum.CONTAIN;
		}
		if (src != null && target == null) {
			return RuleRelationEnum.SUBSET;
		}
		double srcValue = src.doubleValue();
		double targetValue = target.doubleValue();
		
		if (srcValue == -1 && targetValue == -1) {
			return RuleRelationEnum.UNKNOWN;
		}
		if (srcValue == -1 && targetValue != -1) {
			return RuleRelationEnum.CONTAIN;
		}
		if (srcValue != -1 && targetValue == -1) {
			return RuleRelationEnum.SUBSET;
		}
		if (srcValue == targetValue) {
			return RuleRelationEnum.EQUAL;
		}
		return RuleRelationEnum.UNKNOWN;
	}
}
