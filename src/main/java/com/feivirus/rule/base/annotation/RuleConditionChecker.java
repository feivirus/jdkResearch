package com.feivirus.rule.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author feivirus
 * 基于注解的组合模式
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RuleConditionChecker {
	 RuleConditionCheckerType checkType() default RuleConditionCheckerType.STRING_CHECKER;
}
