package com.feivirus.ruleValidator.base;

/**
 * 规则工厂，创建具体规则，比如佣金的，单证的, 承保规则等
 * @author feivirus
 *
 */
public abstract class RuleAbstractFatory {
	public abstract AbstractRule createCommissionRule();
	public abstract AbstractRule createInsuranceDocumentRule();
}
