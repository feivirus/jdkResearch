package com.feivirus.ruleValidator.base.checker;

import java.util.List;

import com.feivirus.ruleValidator.dto.ValueRange;
import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;

public class DoubleValueRangeListConditionChecker implements RuleCondition<List<ValueRange<Double, Double>>>{
	private List<ValueRange<Double, Double>> value;	

	@Override
	public RuleRelationEnum compare(List<ValueRange<Double, Double>> target) {
		RuleRelationEnum relationEnum = ListConditionChecker.compare(value, target);
		return relationEnum;
	}

	public List<ValueRange<Double, Double>> getValue() {
		return value;
	}

	public void setValue(List<ValueRange<Double, Double>> value) {
		this.value = value;
	}
}
