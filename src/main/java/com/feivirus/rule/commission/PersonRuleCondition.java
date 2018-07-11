package com.feivirus.rule.commission;

import com.feivirus.rule.base.annotation.RuleConditionChecker;
import com.feivirus.rule.base.annotation.RuleConditionCheckerType;

/**
 * 
 * @author feivirus
 *
 */
public class PersonRuleCondition{
	//车主性别,参考GenderEnum,对应老版ownerSex,老版ownerSex 是1男 2女
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer ownerGender;
	
	//车主年龄
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer ownerAge;
	
	//被保人年龄
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer insuredAge;
	
	//被保人性别
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer insuredGender;
	
	//被保人同车主
	@RuleConditionChecker(checkType = RuleConditionCheckerType.BOOLEAN_CHECKER)
	private Boolean insurantSameOwner;

	public Integer getOwnerGender() {
		return ownerGender;
	}

	public void setOwnerGender(Integer ownerGender) {
		this.ownerGender = ownerGender;
	}

	public void setInsuredGender(Integer insuredGender) {
		this.insuredGender = insuredGender;
	}

	public Integer getOwnerAge() {
		return ownerAge;
	}

	public void setOwnerAge(Integer ownerAge) {
		this.ownerAge = ownerAge;
	}

	public Integer getInsuredAge() {
		return insuredAge;
	}

	public void setInsuredAge(Integer insuredAge) {
		this.insuredAge = insuredAge;
	}

	public Boolean getInsurantSameOwner() {
		return insurantSameOwner;
	}

	public void setInsurantSameOwner(Boolean insurantSameOwner) {
		this.insurantSameOwner = insurantSameOwner;
	}

	public Integer getInsuredGender() {
		return insuredGender;
	}		
}

