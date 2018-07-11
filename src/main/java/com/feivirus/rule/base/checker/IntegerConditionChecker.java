package com.feivirus.rule.base.checker;

import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class IntegerConditionChecker implements RuleCondition<Integer>{
	private Integer value;
	
	@Override
	public RuleRelationEnum compare(Integer target) {
		RuleRelationEnum relationEnum = NumberConditionChecker.compare(value, target);
		return relationEnum;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value) {		
		this.value = value;
	}
}
