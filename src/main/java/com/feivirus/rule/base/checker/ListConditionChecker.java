package com.feivirus.rule.base.checker;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;
import com.feivirus.rule.base.annotation.RuleConditionChecker;

/**
 * 
 * @author feivirus
 *
 */
public class ListConditionChecker{
	public  static <T> RuleRelationEnum compare(List<T> srcList, List<T > targetList) {
		if (CollectionUtils.isEmpty(srcList) && CollectionUtils.isEmpty(targetList)) {
			return RuleRelationEnum.UNKNOWN;
		}
		if (CollectionUtils.isEmpty(srcList)) {
			return RuleRelationEnum.CONTAIN;
		}
		if (CollectionUtils.isEmpty(targetList)) {
			return RuleRelationEnum.SUBSET;
		}		
	
		boolean hasDiff = false;
		boolean hasSame = false;

		for(T srcItem : srcList) {			
		    boolean exist = false;
		    
			for(T targetItem : targetList) {
				if (srcItem.equals(targetItem)) {
					exist = true;
					break;
				}
			}
			if (exist) {
				hasSame = true;
			} else {
				hasDiff = true;
			}
		}
		
		if (hasSame == true && hasDiff == true) {
			return RuleRelationEnum.INTERSECT;
		}
		if (hasSame == false && hasDiff == true) {
			return RuleRelationEnum.SEPARATE;
		}
		if (hasSame == true && hasDiff == false) {
			int srcListSize = srcList.size();
			int targetListSize = targetList.size();
			
			if (srcListSize == targetListSize) {
				return RuleRelationEnum.EQUAL;
			} else if (srcListSize < targetListSize) {
				return RuleRelationEnum.SUBSET;
			} else if (srcListSize > targetListSize) {
				return RuleRelationEnum.CONTAIN;
			}
		}
		return RuleRelationEnum.UNKNOWN;
	}
}
