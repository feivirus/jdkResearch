package com.feivirus.rule.enums;

/**
 * 
 * @author feivirus
 *
 */
public enum RuleMatchTypeEnum {
    NORMAL(1),
    //不区分规则状态
    NOT_DIFFER_RULE_STATUS(2);
    
    private int value;
    
    private RuleMatchTypeEnum() {       
    }
    
    RuleMatchTypeEnum(int value) {
        this.value = value;
    }
    
    public static RuleMatchTypeEnum getRuleMatchTypeEnum(int param) {
        for(RuleMatchTypeEnum ruleMatchTypeEnum : RuleMatchTypeEnum.values()) {
            if (ruleMatchTypeEnum.getValue() == param) {
                return ruleMatchTypeEnum;
            }
        }
        return null;
    }
    
    public int getValue() {
        return value;
    }

}
