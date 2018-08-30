package com.feivirus.ruleValidator.base;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import com.feivirus.ruleValidator.base.annotation.RuleConditionChecker;
import com.feivirus.ruleValidator.base.annotation.RuleConditionCheckerType;
import com.feivirus.ruleValidator.commission.CommissionRule;

/**
 * 
 * @author feivirus
 * 规则冲突校验
 */
public class RuleValidator {
	
	/**
	 * 校验两条规则是否冲突
	 * @param srcRule
	 * @param targetRule
	 * @return
	 */
	public boolean validateConfict(CommissionRule srcRule, CommissionRule targetRule) {		
		if ((srcRule == null) || (targetRule == null)) {
			return false;
		}
		RuleRelationEnum relationEnum = checkRuleRelation(srcRule, targetRule);
		if (relationEnum == RuleRelationEnum.INTERSECT || 
			relationEnum == RuleRelationEnum.EQUAL) {
			return true;
		}		
		return false;
	}
	
	public RuleRelationEnum checkRuleRelation(CommissionRule srcRule, CommissionRule targetRule) {
		Map<String, PropertyInfo> srcPropertyInfoList = doExtractPropertyInfoWithRuleConditionChecker(srcRule.getCarCommissionRule());
		srcPropertyInfoList.putAll(doExtractPropertyInfoWithRuleConditionChecker(srcRule.getPersonCommissionRule()));
		srcPropertyInfoList.putAll(doExtractPropertyInfoWithRuleConditionChecker(srcRule.getTransactionRouteCommissionRule()));
		srcPropertyInfoList.putAll(doExtractPropertyInfoWithRuleConditionChecker(srcRule.getCompanyPackageRuleCondition()));
		
		Map<String, PropertyInfo> targetPropertyInfoList = doExtractPropertyInfoWithRuleConditionChecker(targetRule.getCarCommissionRule());
		targetPropertyInfoList.putAll(doExtractPropertyInfoWithRuleConditionChecker(targetRule.getPersonCommissionRule()));
		targetPropertyInfoList.putAll(doExtractPropertyInfoWithRuleConditionChecker(targetRule.getTransactionRouteCommissionRule()));
		targetPropertyInfoList.putAll(doExtractPropertyInfoWithRuleConditionChecker(targetRule.getCompanyPackageRuleCondition()));
		
		if (MapUtils.isEmpty(srcPropertyInfoList) && MapUtils.isEmpty(targetPropertyInfoList)) {
			return RuleRelationEnum.UNKNOWN;
		}	
		
		if (MapUtils.isNotEmpty(srcPropertyInfoList) && MapUtils.isEmpty(targetPropertyInfoList)	) {
			return RuleRelationEnum.SUBSET;
		}
		
		if (MapUtils.isEmpty(srcPropertyInfoList) && MapUtils.isNotEmpty(targetPropertyInfoList)) {
			return RuleRelationEnum.CONTAIN;
		}
		
		int separateCount = 0;	
		int intersectCount = 0;
		int containCount = 0;
		int subsetCount = 0;
		int differCount = 0;
		int equalCount = 0;		
		
		Iterator<Map.Entry<String, PropertyInfo>> entries = srcPropertyInfoList.entrySet().iterator();
		
		while (entries.hasNext()) {
			Map.Entry<String, PropertyInfo> entry = entries.next();
			String propertyName = entry.getKey();
			PropertyInfo propertyInfo = entry.getValue();			
			
			RuleConditionCheckerType checkerType = propertyInfo.getCheckerType();			
			if (checkerType == null) {
				continue;
			}
			
			RuleCondition ruleCondition = RuleConditionStaticFactory.createRuleCondition(checkerType, propertyInfo.getPropertyValue());			
			if (ruleCondition == null) {
				continue;
			}		
			
			if (targetPropertyInfoList.containsKey(propertyName)) {
				PropertyInfo targetPropertyInfo = targetPropertyInfoList.get(propertyName);
				
				if (targetPropertyInfo != null) {
					RuleRelationEnum relationEnum = ruleCondition.compare(targetPropertyInfo.getPropertyValue());
					
					switch (relationEnum) {
					case INTERSECT:
						intersectCount++;
						differCount++;
						break;
					case SEPARATE:
						separateCount++;
						differCount++;
						break;
					case CONTAIN:
						containCount++;
						differCount++;
						break;
					case SUBSET:
						subsetCount++;
						differCount++;
						break;
					case EQUAL:
						equalCount++;
						break;
					default:
						break;
					}
				}				
			} else {
				subsetCount++;
				differCount++;
			}			
		}			
		
		if (differCount == 0 &&
			equalCount > 0) {
			return RuleRelationEnum.EQUAL;
		} else if (separateCount > 0) {
			return RuleRelationEnum.SEPARATE;
		} else if (intersectCount > 0) {
			return RuleRelationEnum.INTERSECT;
		} else if (containCount > 0) {
			return RuleRelationEnum.CONTAIN;
		} else if (subsetCount > 0) {
			return RuleRelationEnum.SUBSET;
		} else {
			return RuleRelationEnum.UNKNOWN;
		}
	}
	
	/**
	 * 返回带有RuleConditionChecker的属性信息
	 * @param rule
	 * @return
	 */
	public <T> Map<String, PropertyInfo> doExtractPropertyInfoWithRuleConditionChecker(T t) {
		Map<String, PropertyInfo> propertyMap = new HashMap<String, PropertyInfo>();
		if (t == null) {
			return propertyMap;
		}
		
		Class<?> clazz = t.getClass();
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			RuleConditionChecker checker = field.getAnnotation(RuleConditionChecker.class);
			
			if (checker != null) {
				String fieldName = field.getName();
				RuleConditionCheckerType checkerType = checker.checkType();
				
				PropertyInfo propertyInfo = new PropertyInfo();				
				propertyInfo.setPropertyName(fieldName);
				propertyInfo.setCheckerType(checkerType);
				Object propertyValue = getPropertyValue(t, fieldName);
				if (propertyValue != null) {
					propertyInfo.setPropertyValue(propertyValue);
				}				
				propertyMap.put(fieldName, propertyInfo);
			}
		}		
	
		return propertyMap;
	}
	
	public static <T> Object getPropertyValue(T t, String fieldName) {
		if (StringUtils.isBlank(fieldName)) {
			return null;
		}
		Object value = null;
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
			PropertyDescriptor[] propertyDescriptorList = beanInfo.getPropertyDescriptors();
			
			for(PropertyDescriptor descriptor : propertyDescriptorList) {
				if (fieldName.equals(descriptor.getName())) {
					Method method = descriptor.getReadMethod();
					
					if (method != null) {
						value = method.invoke(t, null);
						break;
					} else {
						value = descriptor.getValue(fieldName);
					}
				}
			}
			
		} catch (Exception e) {			
		}
		return value;
	}
	
	
	public class PropertyInfo {
		//类中字段名
		private String propertyName;
		
		//类中字段的getter方法
		private Method readMethod;
		
		//类中字段的值
		private Object propertyValue;
		
		//属性的校验类型
		private RuleConditionCheckerType checkerType;

		public String getPropertyName() {
			return propertyName;
		}

		public Method getReadMethod() {
			return readMethod;
		}

		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}

		public void setReadMethod(Method readMethod) {
			this.readMethod = readMethod;
		}

		public Object getPropertyValue() {
			return propertyValue;
		}

		public void setPropertyValue(Object propertyValue) {
			this.propertyValue = propertyValue;
		}

		public RuleConditionCheckerType getCheckerType() {
			return checkerType;
		}

		public void setCheckerType(RuleConditionCheckerType checkerType) {
			this.checkerType = checkerType;
		}			
	}
}
