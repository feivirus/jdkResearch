package com.feivirus.ruleValidator.base.checker;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class StringConditionChecker implements RuleCondition<String>{
	
	private String value;

	@Override
	public RuleRelationEnum compare(String target) {
		if (StringUtils.isBlank(value) || StringUtils.isBlank(target)) {
			return RuleRelationEnum.UNKNOWN;
		}
		if (value.equals(target)) {
			return RuleRelationEnum.EQUAL;
		}
		if (value.contains(target)) {
			return RuleRelationEnum.CONTAIN;
		}
		if (target.contains(value)) {	
			return RuleRelationEnum.SUBSET;
		}
		//TODO
		//判断相交，比如ABCD,CDEF
		return RuleRelationEnum.SEPARATE;
	}
	
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
}
