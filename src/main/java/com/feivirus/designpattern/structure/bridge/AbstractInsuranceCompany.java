package com.feivirus.designpattern.structure.bridge;

public abstract class AbstractInsuranceCompany {
	private String companyName;
	
	private String companyCode;
	
	protected AbstractInsurancePolicyAction abstractInsurancePolicyAction;
	
	public abstract void run();

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public AbstractInsurancePolicyAction getAbstractInsurancePolicyAction() {
		return abstractInsurancePolicyAction;
	}

	public void setAbstractInsurancePolicyAction(AbstractInsurancePolicyAction abstractInsurancePolicyAction) {
		this.abstractInsurancePolicyAction = abstractInsurancePolicyAction;
	}
}
