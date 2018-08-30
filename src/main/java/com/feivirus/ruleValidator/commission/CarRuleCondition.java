package com.feivirus.ruleValidator.commission;

import java.util.List;
import com.feivirus.ruleValidator.dto.ValueRange;
import com.feivirus.ruleValidator.base.annotation.RuleConditionChecker;
import com.feivirus.ruleValidator.base.annotation.RuleConditionCheckerType;

/**
 * 佣金规则中车辆相关信息
 * @author feivirus
 *
 */
public class CarRuleCondition{
	
	//车型列表A,B,C,D,E		
	@RuleConditionChecker(checkType = RuleConditionCheckerType.STRING_LIST_CHECKER)
	private List<String> modelList;
	
	//过户车/非过户车,参考TransferCarEnum
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer isTransfer;
	
	//车龄
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_VALUE_RANGE_CHECKER)
	private ValueRange<Integer, Integer> carYear;
	
	//使用性质 私家车/单位车/出租车,参考UseNatureEnum
	@RuleConditionChecker(checkType = RuleConditionCheckerType.STRING_LIST_CHECKER)
	private List<String> useNatureList;
	
	//车辆种类 客车/货车 参考CarTypeEnum
	@RuleConditionChecker(checkType = RuleConditionCheckerType.STRING_LIST_CHECKER)
	private List<String> carTypeList;
	
	//号牌种类 小型车/汽车/警车 参考PlateTypeEnum
	@RuleConditionChecker(checkType = RuleConditionCheckerType.STRING_LIST_CHECKER)
	private List<String> plateTypeList;	
	
	//座位数
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_VALUE_RANGE_CHECKER)
	private ValueRange<Integer, Integer> seat;
	
	//吨位
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_VALUE_RANGE_CHECKER)
	private ValueRange<Integer, Integer> tonnage;
	
	//异地车
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer diffCar;
	
	//0 未脱保 1脱保 参考OutInsuredCarEnum 
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer outInsuredCar;
	
	//起保时间
	private String packageBeginTime;
	
	//风险类别 A/B/C/D/E/Z/空格
	@RuleConditionChecker(checkType = RuleConditionCheckerType.STRING_LIST_CHECKER)
	private List<String> riskCategory;
	
	//车型风险等级
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_VALUE_RANGE_CHECKER)
	private ValueRange<Integer, Integer> modelRiskCategory;
	
	//预期赔付率
	@RuleConditionChecker(checkType = RuleConditionCheckerType.DOUBLE_VALUE_RANGE_CHECKER)
	private ValueRange<Double, Double> expectedPaymentRate;
	
	//交商合计预期赔付率
	@RuleConditionChecker(checkType = RuleConditionCheckerType.DATE_VALUE_RANGE_CHECKER)
	private ValueRange<Double, Double> forceAndBisTotalEPR;
	
	//是否贷款车
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_CHECKER)
	private Integer isLoanCar;
	
	//出险次数,参考NonLossRatioEnum
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_LIST_CHECKER)
	private List<Integer> nonLossRatios;
	
	//不浮动原因
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_LIST_CHECKER)
	private List<Integer> noClaimAdjustReason;		
	
	//自主核保系数*自主渠道系数
	@RuleConditionChecker(checkType = RuleConditionCheckerType.DOUBLE_VALUE_RANGE_CHECKER)
	private ValueRange<Double, Double> checkRatioMultiplyChannelRatio;	
	
	//车价列表,单位万元
	@RuleConditionChecker(checkType = RuleConditionCheckerType.DOUBLE_VALUE_RANGE_LIST_CHECKER)
	private List<ValueRange<Double, Double>> srcPriceList;
	
	//车型产地类别 1 进口 0 国产
	@RuleConditionChecker(checkType = RuleConditionCheckerType.INTEGER_LIST_CHECKER)
	private List<Integer> countryNature;

	public List<String> getModelList() {
		return modelList;
	}

	public void setModelList(List<String> modelList) {
		this.modelList = modelList;
	}

	public Integer getIsTransfer() {
		return isTransfer;
	}

	public void setIsTransfer(Integer isTransfer) {
		this.isTransfer = isTransfer;
	}

	public ValueRange<Integer, Integer> getCarYear() {
		return carYear;
	}

	public void setCarYear(ValueRange<Integer, Integer> carYear) {
		this.carYear = carYear;
	}

	public List<String> getUseNatureList() {
		return useNatureList;
	}

	public void setUseNatureList(List<String> useNatureList) {
		this.useNatureList = useNatureList;
	}

	public List<String> getCarTypeList() {
		return carTypeList;
	}

	public void setCarTypeList(List<String> carTypeList) {
		this.carTypeList = carTypeList;
	}

	public List<String> getPlateTypeList() {
		return plateTypeList;
	}

	public void setPlateTypeList(List<String> plateTypeList) {
		this.plateTypeList = plateTypeList;
	}

	public ValueRange<Integer, Integer> getSeat() {
		return seat;
	}

	public void setSeat(ValueRange<Integer, Integer> seat) {
		this.seat = seat;
	}

	public ValueRange<Integer, Integer> getTonnage() {
		return tonnage;
	}

	public void setTonnage(ValueRange<Integer, Integer> tonnage) {
		this.tonnage = tonnage;
	}

	public Integer getDiffCar() {
		return diffCar;
	}

	public void setDiffCar(Integer diffCar) {
		this.diffCar = diffCar;
	}

	public Integer getOutInsuredCar() {
		return outInsuredCar;
	}

	public void setOutInsuredCar(Integer outInsuredCar) {
		this.outInsuredCar = outInsuredCar;
	}

	public String getPackageBeginTime() {
		return packageBeginTime;
	}

	public void setPackageBeginTime(String packageBeginTime) {
		this.packageBeginTime = packageBeginTime;
	}

	public List<String> getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(List<String> riskCategory) {
		this.riskCategory = riskCategory;
	}

	public ValueRange<Integer, Integer> getModelRiskCategory() {
		return modelRiskCategory;
	}

	public void setModelRiskCategory(ValueRange<Integer, Integer> modelRiskCategory) {
		this.modelRiskCategory = modelRiskCategory;
	}

	public ValueRange<Double, Double> getExpectedPaymentRate() {
		return expectedPaymentRate;
	}

	public void setExpectedPaymentRate(ValueRange<Double, Double> expectedPaymentRate) {
		this.expectedPaymentRate = expectedPaymentRate;
	}

	public ValueRange<Double, Double> getForceAndBisTotalEPR() {
		return forceAndBisTotalEPR;
	}

	public void setForceAndBisTotalEPR(ValueRange<Double, Double> forceAndBisTotalEPR) {
		this.forceAndBisTotalEPR = forceAndBisTotalEPR;
	}

	public Integer getIsLoanCar() {
		return isLoanCar;
	}

	public void setIsLoanCar(Integer isLoanCar) {
		this.isLoanCar = isLoanCar;
	}

	public List<Integer> getNonLossRatios() {
		return nonLossRatios;
	}

	public void setNonLossRatios(List<Integer> nonLossRatios) {
		this.nonLossRatios = nonLossRatios;
	}

	public List<Integer> getNoClaimAdjustReason() {
		return noClaimAdjustReason;
	}

	public void setNoClaimAdjustReason(List<Integer> noClaimAdjustReason) {
		this.noClaimAdjustReason = noClaimAdjustReason;
	}

	public ValueRange<Double, Double> getCheckRatioMultiplyChannelRatio() {
		return checkRatioMultiplyChannelRatio;
	}

	public void setCheckRatioMultiplyChannelRatio(ValueRange<Double, Double> checkRatioMultiplyChannelRatio) {
		this.checkRatioMultiplyChannelRatio = checkRatioMultiplyChannelRatio;
	}
	
	public List<ValueRange<Double, Double>> getSrcPriceList() {
		return srcPriceList;
	}

	public void setSrcPriceList(List<ValueRange<Double, Double>> srcPriceList) {
		this.srcPriceList = srcPriceList;
	}

	public List<Integer> getCountryNature() {
		return countryNature;
	}

	public void setCountryNature(List<Integer> countryNature) {
		this.countryNature = countryNature;
	}		
}
