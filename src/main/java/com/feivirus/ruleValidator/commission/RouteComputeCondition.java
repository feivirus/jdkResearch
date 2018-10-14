package com.feivirus.ruleValidator.commission;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.springframework.data.annotation.Transient;

import  com.feivirus.ruleValidator.dto.IssueAgency;
import  com.feivirus.ruleValidator.dto.SysAreaDTO;
import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;
import com.feivirus.ruleValidator.base.annotation.RuleConditionChecker;
import com.feivirus.ruleValidator.base.annotation.RuleConditionCheckerType;
//import com.ideacome.common.enums.BusinessType;
//import com.ideacome.common.enums.CarTypeEnum;
import com.feivirus.ruleValidator.enums.QuoteTypeEnum;

/**
 * 交易路由相关信息
 * @author feivirus
 *
 */
public class RouteComputeCondition{
	//适用地区,老版的areaDefList
	@RuleConditionChecker(checkType = RuleConditionCheckerType.SYS_AREA_LIST_CHECKER)
	private List<SysAreaDTO> sysAreaList;	
	
	//适用地区,用于前端处理,老版的areaResource
	private String areaResourceVO;
	
	//网销适用地区，用于前端处理，老版的agencyDefList
	@RuleConditionChecker(checkType = RuleConditionCheckerType.SYS_AREA_LIST_CHECKER)
	private List<SysAreaDTO> sysAreaDTOList;
	
	//适用地区,老版的agencyList
	private List<IssueAgency> issueAgencyList;
	
	//前端传上来的出单机构id列表,逗号分隔,用于蜂巢
	private String agencyListVO;
	
	//出单机构,用于前端处理,用于蜂巢
	private String agencyListVOResource;
	
	//网销出单机构,用于前端处理
	private String agencyResource;	
	
	//合同号
	private String contractNo;
	
	//参考ContractTypeEnum,ABCED,单选
	private String contractType;
	
	//险企code
	private String companyCode;
	
	//业务类型 网销/蜂巢
	//private BusinessType businessType;	
	
	//商业险点数
	private Double bizPoint;
	
	//交强险点数
	private Double forcePoint;
	
	//服务费
	private Double serviceExpense;	
	
	//生效时间
	private Date effectiveDate;
	
	//过期时间
	private Date expirationDate;
	
	@RuleConditionChecker(checkType = RuleConditionCheckerType.DATE_STRING_LIST_CHECKER)
	@Transient
	private List<String> effectiveDateList;
	
	//规则权重,范围越小，权重越大 
	private Integer weight;
	
	//在同一应收规则中的不同继承关系家族的计数,用于辅助计算权重 , 1开始
	private Integer differFamilyCount;
	
	//计算类型  1 佣金比例 2 一车一价  3.指定点数
	private Integer computeType;
	
	//结算方式 1净保费计算 2非净保费计算
	private Integer balanceType;

	public List<SysAreaDTO> getSysAreaList() {
		return sysAreaList;
	}

	public void setSysAreaList(List<SysAreaDTO> sysAreaList) {
		this.sysAreaList = sysAreaList;
	}

	public String getAreaResourceVO() {
		return areaResourceVO;
	}

	public void setAreaResourceVO(String areaResourceVO) {
		this.areaResourceVO = areaResourceVO;
	}

	public List<SysAreaDTO> getSysAreaDTOList() {
		return sysAreaDTOList;
	}

	public void setSysAreaDTOList(List<SysAreaDTO> sysAreaDTOList) {
		this.sysAreaDTOList = sysAreaDTOList;
	}

	public List<IssueAgency> getIssueAgencyList() {
		return issueAgencyList;
	}

	public void setIssueAgencyList(List<IssueAgency> issueAgencyList) {
		this.issueAgencyList = issueAgencyList;
	}

	public String getAgencyListVO() {
		return agencyListVO;
	}

	public void setAgencyListVO(String agencyListVO) {
		this.agencyListVO = agencyListVO;
	}

	public String getAgencyListVOResource() {
		return agencyListVOResource;
	}

	public void setAgencyListVOResource(String agencyListVOResource) {
		this.agencyListVOResource = agencyListVOResource;
	}

	public String getAgencyResource() {
		return agencyResource;
	}

	public void setAgencyResource(String agencyResource) {
		this.agencyResource = agencyResource;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	//public BusinessType getBusinessType() {
	//	return businessType;
	//}

	//public void setBusinessType(BusinessType businessType) {
	//	this.businessType = businessType;
	//}

	public Double getBizPoint() {
		return bizPoint;
	}

	public void setBizPoint(Double bizPoint) {
		this.bizPoint = bizPoint;
	}

	public Double getForcePoint() {
		return forcePoint;
	}

	public void setForcePoint(Double forcePoint) {
		this.forcePoint = forcePoint;
	}

	public Double getServiceExpense() {
		return serviceExpense;
	}

	public void setServiceExpense(Double serviceExpense) {
		this.serviceExpense = serviceExpense;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<String> getEffectiveDateList() {
		return effectiveDateList;
	}

	public void setEffectiveDateList(List<String> effectiveDateList) {
		this.effectiveDateList = effectiveDateList;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getDifferFamilyCount() {
		return differFamilyCount;
	}

	public void setDifferFamilyCount(Integer differFamilyCount) {
		this.differFamilyCount = differFamilyCount;
	}

	public Integer getComputeType() {
		return computeType;
	}

	public void setComputeType(Integer computeType) {
		this.computeType = computeType;
	}

	public Integer getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(Integer balanceType) {
		this.balanceType = balanceType;
	}		
}