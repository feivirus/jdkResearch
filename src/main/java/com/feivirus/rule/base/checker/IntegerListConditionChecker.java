package com.feivirus.rule.base.checker;

import java.util.List;

import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class IntegerListConditionChecker implements RuleCondition<List<Integer>>{
	private List<Integer> value;

	@Override
	public RuleRelationEnum compare(List<Integer> target) {
		RuleRelationEnum relationEnum = ListConditionChecker.compare(value, target);
		return relationEnum;
	}

	@Override
	public List<Integer> getValue() {
		return value;
	}

	@Override
	public void setValue(List<Integer> value) {
		this.value = value;
	}	
}
