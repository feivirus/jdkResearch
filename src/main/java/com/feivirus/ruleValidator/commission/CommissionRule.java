package com.feivirus.ruleValidator.commission;

import java.io.Serializable;

import com.feivirus.ruleValidator.base.AbstractRule;

/**
 * 佣金规则
 * @author feivirus
 *
 */
public class CommissionRule extends AbstractRule{

	private static final long serialVersionUID = 1477022210505736993L;
	
	private CarRuleCondition carCommissionRule;
	
	private CompanyPackageRuleCondition companyPackageRuleCondition;
	
	private PersonRuleCondition personCommissionRule;
	
	private RouteComputeCondition transactionRouteCommissionRule;
	
	private CommissionRule(Builder builder) {
		carCommissionRule = builder.carCommissionRule;
		companyPackageRuleCondition = builder.itemSetCommissionRule;
		personCommissionRule = builder.personCommissionRule;
		transactionRouteCommissionRule = builder.transactionRouteCommissionRule;
	}
	
	public CarRuleCondition getCarCommissionRule() {
		return carCommissionRule;
	}

	public void setCarCommissionRule(CarRuleCondition carCommissionRule) {
		this.carCommissionRule = carCommissionRule;
	}

	public CompanyPackageRuleCondition getCompanyPackageRuleCondition() {
		return companyPackageRuleCondition;
	}

	public void setCompanyPackageRuleCondition(CompanyPackageRuleCondition itemSetCommissionRule) {
		this.companyPackageRuleCondition = itemSetCommissionRule;
	}

	public PersonRuleCondition getPersonCommissionRule() {
		return personCommissionRule;
	}

	public void setPersonCommissionRule(PersonRuleCondition personCommissionRule) {
		this.personCommissionRule = personCommissionRule;
	}

	public RouteComputeCondition getTransactionRouteCommissionRule() {
		return transactionRouteCommissionRule;
	}

	public void setTransactionRouteCommissionRule(RouteComputeCondition transactionRouteCommissionRule) {
		this.transactionRouteCommissionRule = transactionRouteCommissionRule;
	}

	public static class Builder {
		private CarRuleCondition carCommissionRule;
		
		private CompanyPackageRuleCondition itemSetCommissionRule;
		
		private PersonRuleCondition personCommissionRule;
		
		private RouteComputeCondition transactionRouteCommissionRule;

		public Builder setCarCommissionRule(CarRuleCondition carCommissionRule) {
			this.carCommissionRule = carCommissionRule;
			return this;
		}

		public Builder setCompanyPackageRuleCondition(CompanyPackageRuleCondition itemSetCommissionRule) {
			this.itemSetCommissionRule = itemSetCommissionRule;
			return this;
		}

		public Builder setPersonCommissionRule(PersonRuleCondition personCommissionRule) {
			this.personCommissionRule = personCommissionRule;
			return this;
		}

		public Builder setTransactionRouteCommissionRule(RouteComputeCondition transactionRouteCommissionRule) {
			this.transactionRouteCommissionRule = transactionRouteCommissionRule;
			return this;
		}
		
		public CommissionRule build() {
			return new CommissionRule(this);
		}
	}	
}
