package com.feivirus.rule.base.checker;

import com.feivirus.rule.dto.ValueRange;
import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class IntegerValueRangeConditionChecker  extends ValueRange<Integer, Integer> implements RuleCondition<ValueRange<Integer, Integer>> {

	public IntegerValueRangeConditionChecker(Integer s, Integer e) {
		super(s, e);		
	}

	@Override
	public RuleRelationEnum compare(ValueRange<Integer, Integer> target) {
		ValueRange<Integer, Integer> src = new ValueRange<Integer, Integer>(start, end);
		RuleRelationEnum relationEnum = compare(src, target);
		return relationEnum;
	}

	@Override
	public ValueRange<Integer, Integer> getValue() {
		ValueRange<Integer, Integer> valueRange = new ValueRange<Integer, Integer>(start, end);
		return valueRange;
	}

	@Override
	public void setValue(ValueRange<Integer, Integer> value) {
		if (value != null) {
			start = value.getStart();
			end = value.getEnd();
		} else {
			value = null;
			end = null;
		}				
	}
}
