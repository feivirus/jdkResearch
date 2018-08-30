package com.feivirus.ruleValidator.base;

import java.util.Date;
import java.util.List;
import com.feivirus.ruleValidator.base.annotation.RuleConditionCheckerType;
import com.feivirus.ruleValidator.base.checker.BooleanConditionChecker;
import com.feivirus.ruleValidator.base.checker.DateStringListConditionChecker;
import com.feivirus.ruleValidator.base.checker.DateValueRangeConditionChecker;
import com.feivirus.ruleValidator.base.checker.DoubleValueRangeConditionChecker;
import com.feivirus.ruleValidator.base.checker.DoubleValueRangeListConditionChecker;
import com.feivirus.ruleValidator.base.checker.IntegerConditionChecker;
import com.feivirus.ruleValidator.base.checker.IntegerListConditionChecker;
import com.feivirus.ruleValidator.base.checker.IntegerValueRangeConditionChecker;
import com.feivirus.ruleValidator.base.checker.IntegerValueRangeListConditionChecker;
import com.feivirus.ruleValidator.base.checker.StringConditionChecker;
import com.feivirus.ruleValidator.base.checker.StringListConditionChecker;
import com.feivirus.ruleValidator.base.checker.SysAreaListConditionChecker;
import com.feivirus.ruleValidator.dto.SysAreaDTO;
import com.feivirus.ruleValidator.dto.ValueRange;

/**
 * 
 * @author feivirus
 *
 */
public class RuleConditionStaticFactory {
	
	public static RuleCondition createRuleCondition(RuleConditionCheckerType checkerType, Object value) {
		if (checkerType == null ||
			value == null) {
			return null;
		}
		if (checkerType == RuleConditionCheckerType.STRING_CHECKER) {
			StringConditionChecker conditionChecker = new StringConditionChecker();
			conditionChecker.setValue(String.valueOf(value));
			return conditionChecker;
		} 
		
		if (checkerType == RuleConditionCheckerType.INTEGER_CHECKER) {
			IntegerConditionChecker conditionChecker = new IntegerConditionChecker();
			conditionChecker.setValue((Integer)value);
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.DATE_VALUE_RANGE_CHECKER) {
			ValueRange<Date, Date> dateValueRange = (ValueRange<Date, Date>)value;
			DateValueRangeConditionChecker conditionChecker = new DateValueRangeConditionChecker(dateValueRange.getStart(), 
					dateValueRange.getEnd());
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.DOUBLE_VALUE_RANGE_CHECKER) {
			ValueRange<Double, Double> doubleValueRange = (ValueRange<Double, Double>)value;
			DoubleValueRangeConditionChecker conditionChecker = new DoubleValueRangeConditionChecker(doubleValueRange.getStart(), 
					doubleValueRange.getEnd());
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.DOUBLE_VALUE_RANGE_LIST_CHECKER) {
			List<ValueRange<Double, Double>> rangeList = (List<ValueRange<Double,Double>>)value;
			DoubleValueRangeListConditionChecker conditionChecker = new DoubleValueRangeListConditionChecker();
			conditionChecker.setValue(rangeList);
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.STRING_LIST_CHECKER) {
			List<String> stringList = (List<String>)value;
			StringListConditionChecker conditionChecker = new StringListConditionChecker();
			conditionChecker.setValue(stringList);
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.SYS_AREA_LIST_CHECKER) {
			List<SysAreaDTO> sysAreaList = (List<SysAreaDTO>)value;
			SysAreaListConditionChecker conditionChecker = new SysAreaListConditionChecker();
			conditionChecker.setValue(sysAreaList);
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.INTEGER_VALUE_RANGE_CHECKER) {
			ValueRange<Integer, Integer> rangeList = (ValueRange<Integer, Integer>)value;
			IntegerValueRangeConditionChecker conditionChecker = new IntegerValueRangeConditionChecker(rangeList.getStart(), 
					rangeList.getEnd());
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.BOOLEAN_CHECKER) {
			BooleanConditionChecker conditionChecker = new BooleanConditionChecker();
			conditionChecker.setValue((Boolean)value);
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.DATE_STRING_LIST_CHECKER) {
			DateStringListConditionChecker conditionChecker = new DateStringListConditionChecker();
			conditionChecker.setValue((List<String>) value);
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.INTEGER_LIST_CHECKER) {
			IntegerListConditionChecker conditionChecker = new IntegerListConditionChecker();
			conditionChecker.setValue((List<Integer>)value);
			return conditionChecker;
		}
		
		if (checkerType == RuleConditionCheckerType.INTEGER_VALUE_RANGE_LIST_CHECKER) {
			IntegerValueRangeListConditionChecker conditionChecker = new IntegerValueRangeListConditionChecker();
			conditionChecker.setValue((List<ValueRange<Integer,Integer>>)value);
			return conditionChecker;
		}
		return null;
	}
}
