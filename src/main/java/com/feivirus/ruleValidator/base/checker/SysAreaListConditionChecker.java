package com.feivirus.ruleValidator.base.checker;

import java.util.List;
import com.feivirus.ruleValidator.dto.SysAreaDTO;
import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class SysAreaListConditionChecker implements RuleCondition<List<SysAreaDTO>>{
	private List<SysAreaDTO> value;
	
	@Override
	public RuleRelationEnum compare(List<SysAreaDTO> target) {
		RuleRelationEnum relationEnum = ListConditionChecker.compare(value, target);
		return relationEnum;
		
	}

	@Override
	public List<SysAreaDTO> getValue() {
		return value;
	}

	@Override
	public void setValue(List<SysAreaDTO> value) {
		this.value = value;		
	}
}
