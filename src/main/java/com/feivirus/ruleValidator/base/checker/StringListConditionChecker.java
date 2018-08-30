package com.feivirus.ruleValidator.base.checker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class StringListConditionChecker implements RuleCondition<List<String>>{
	private List<String> value;
	
	@Override
	public RuleRelationEnum compare(List<String> target) {
		RuleRelationEnum relationEnum = ListConditionChecker.compare(value, target);
		return relationEnum;
	}

	@Override
	public List<String> getValue() {
		return value;
	}

	@Override
	public void setValue(List<String> value) {
		this.value = value;		
	}	
}
