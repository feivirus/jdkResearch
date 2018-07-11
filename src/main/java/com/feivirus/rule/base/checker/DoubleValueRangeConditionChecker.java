package com.feivirus.rule.base.checker;

import com.feivirus.rule.dto.ValueRange;
import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class DoubleValueRangeConditionChecker extends ValueRange<Double, Double> implements RuleCondition<ValueRange<Double, Double>>{

	public DoubleValueRangeConditionChecker(Double s, Double e) {
		super(s, e);
	}

	@Override
	public RuleRelationEnum compare(ValueRange<Double, Double> target) {
		ValueRange<Double, Double> srcRange = new ValueRange<>(start, end);
		RuleRelationEnum relationEnum = compare(srcRange, target);
		return relationEnum;
	}

	@Override
	public ValueRange<Double, Double> getValue() {
		ValueRange<Double, Double> valueRange = new ValueRange<Double, Double>(start, end);
		return valueRange;
	}

	@Override
	public void setValue(ValueRange<Double, Double> value) {
		if (value != null) {
			start = value.getStart();
			end = value.getEnd();
		} else {
			value = null;
			end = null;
		}		
	}
}
