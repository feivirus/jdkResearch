package com.feivirus.ruleValidator.commission;

import org.springframework.data.annotation.Transient;
import java.util.Date;
import java.util.List;
import com.feivirus.ruleValidator.dto.LevelGroup;
import com.feivirus.ruleValidator.dto.PackageItemDTO;
import com.feivirus.ruleValidator.dto.ValueRange;
//import com.ideacome.common.enums.RenewalEnum;
import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;
import com.feivirus.ruleValidator.base.annotation.RuleConditionChecker;
import com.feivirus.ruleValidator.base.annotation.RuleConditionCheckerType;
import com.feivirus.ruleValidator.enums.RuleMatchTypeEnum;

/**
 * 保险公司套餐相关信息
 * @author feivirus
 *
 */
public class CompanyPackageRuleCondition{
	//转保/续保/新保
	//@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	//private RenewalEnum renewalEnum;
	
	//业务级别1
	private LevelGroup firstLevelGroup;
	
	//业务级别2
	private LevelGroup secondLevelGroup;

	//商业险分类
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_VALUE_RANGE_CHECKER)
	private ValueRange<Integer, Integer> businessClass;
	
	//交强险分类
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_VALUE_RANGE_CHECKER)
	private ValueRange<Integer, Integer> forceClass;
	
	//套餐类型,参考PackageTypeEnum. 老版的InsuranceAssociation, 1商业 2交商联保 3交强
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer packageType;
	
	//前端传上来的套餐组合，多选
	@Transient
	private List<Integer> insuranceAssociationList;
	
	//三级业务-英大网销
	private String level3Business;
	
	//四级业务列表-英大网销
	private List<String> level4BussinessList; 
	
	//险别组合
	//TODO 冲突检验,需求未定，暂时留空
	private List<PackageItemDTO> packageItemList;

	//public RenewalEnum getRenewalEnum() {
	//	return renewalEnum;
	//}

	//public void setRenewalEnum(RenewalEnum renewalEnum) {
	//	this.renewalEnum = renewalEnum;
	//}

	public LevelGroup getFirstLevelGroup() {
		return firstLevelGroup;
	}

	public void setFirstLevelGroup(LevelGroup firstLevelGroup) {
		this.firstLevelGroup = firstLevelGroup;
	}

	public LevelGroup getSecondLevelGroup() {
		return secondLevelGroup;
	}

	public void setSecondLevelGroup(LevelGroup secondLevelGroup) {
		this.secondLevelGroup = secondLevelGroup;
	}

	public ValueRange<Integer, Integer> getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(ValueRange<Integer, Integer> businessClass) {
		this.businessClass = businessClass;
	}

	public ValueRange<Integer, Integer> getForceClass() {
		return forceClass;
	}

	public void setForceClass(ValueRange<Integer, Integer> forceClass) {
		this.forceClass = forceClass;
	}

	public Integer getPackageType() {
		return packageType;
	}

	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}

	public List<Integer> getInsuranceAssociationList() {
		return insuranceAssociationList;
	}

	public void setInsuranceAssociationList(List<Integer> insuranceAssociationList) {
		this.insuranceAssociationList = insuranceAssociationList;
	}

	public String getLevel3Business() {
		return level3Business;
	}

	public void setLevel3Business(String level3Business) {
		this.level3Business = level3Business;
	}

	public List<String> getLevel4BussinessList() {
		return level4BussinessList;
	}

	public void setLevel4BussinessList(List<String> level4BussinessList) {
		this.level4BussinessList = level4BussinessList;
	}

	public List<PackageItemDTO> getPackageItemList() {
		return packageItemList;
	}

	public void setPackageItemList(List<PackageItemDTO> packageItemList) {
		this.packageItemList = packageItemList;
	}	
}

