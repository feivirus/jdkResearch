package com.feivirus.ruleValidator.base;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 */
public interface RuleCondition<T> {
	//判断两个条件的关系，用于入库时的冲突检测
	public RuleRelationEnum compare(T target);
	
	//TODO
	//是否能命中
	//public boolean match(T obj);	
	
	//获取规则条件的值
	public T getValue();
	
	//设置规则条件中的值
	public void setValue(T value);
}
