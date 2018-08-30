package com.feivirus.ruleValidator;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.feivirus.ruleValidator.base.RuleValidator;
import com.feivirus.ruleValidator.commission.CarRuleCondition;
import com.feivirus.ruleValidator.commission.CommissionRule;

public class CommissionRuleTest {
	
	private CommissionRule srcRule;
	
	private CommissionRule targetRule;
	
	@Before
	public void initCommissionRule() {
		CarRuleCondition carRuleCondition = new CarRuleCondition();
		List<String> plateTypeList = new ArrayList<String>();
		plateTypeList.add("浙A12345");
		carRuleCondition.setPlateTypeList(plateTypeList);
		
		srcRule = new CommissionRule.Builder().setCarCommissionRule(carRuleCondition).build();
		targetRule = new CommissionRule.Builder().setCarCommissionRule(carRuleCondition).build();		
	}
	
	@Test
	public void  testCommissionRuleConflict() {
		RuleValidator ruleValidator = new RuleValidator();
		
		Assert.assertTrue(ruleValidator.validateConfict(srcRule, targetRule));	
	}
}