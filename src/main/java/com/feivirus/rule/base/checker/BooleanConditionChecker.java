package com.feivirus.rule.base.checker;

import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;

public class BooleanConditionChecker implements RuleCondition<Boolean>{
	private Boolean value;

	@Override
	public RuleRelationEnum compare(Boolean target) {
		
		if (value == null && target == null) {
			return RuleRelationEnum.UNKNOWN;
		}
		if (value == null) {
			return RuleRelationEnum.CONTAIN;
		}
		if (target == null) {
			return RuleRelationEnum.SUBSET;
		}
		if (value.equals(target)) {
			return RuleRelationEnum.EQUAL;
		} else {
			return RuleRelationEnum.SEPARATE;
		}
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public void setValue(Boolean value) {
		this.value = value;
	}
	
}
