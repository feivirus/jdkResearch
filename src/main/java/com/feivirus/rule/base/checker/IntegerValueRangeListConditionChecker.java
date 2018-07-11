package com.feivirus.rule.base.checker;

import java.util.List;

import com.feivirus.rule.dto.ValueRange;
import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class IntegerValueRangeListConditionChecker implements RuleCondition<List<ValueRange<Integer, Integer>>>{
	private List<ValueRange<Integer, Integer>> value;
	
	@Override
	public RuleRelationEnum compare(List<ValueRange<Integer, Integer>> target) {
		RuleRelationEnum relationEnum = ListConditionChecker.compare(value, target);
		return relationEnum;
	}

	@Override
	public List<ValueRange<Integer, Integer>> getValue() {
		return value;
	}

	@Override
	public void setValue(List<ValueRange<Integer, Integer>> value) {
		this.value = value;
	}
}
