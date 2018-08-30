package com.feivirus.ruleValidator.base.checker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.feivirus.ruleValidator.dto.ValueRange;
import com.feivirus.ruleValidator.base.RuleCondition;
import com.feivirus.ruleValidator.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class DateStringListConditionChecker implements RuleCondition<List<String>>{
	private List<String> value;

	@Override
	public RuleRelationEnum compare(List<String> target) {
		//先把String转成Date，再比较关系
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strSrcStartDate = value.get(0);
        String strSrcEndDate = value.get(1);
        String strTargetStartDate = target.get(0);
        String strTargetEndDate = target.get(1);
        Date srcStartDate = null;
        Date srcEndDate = null;
        Date targetStartDate = null;
        Date targetEndDate = null;
        
        try {
			srcEndDate = simpleDateFormat.parse(strSrcStartDate);
			srcEndDate = simpleDateFormat.parse(strSrcEndDate);
			targetStartDate = simpleDateFormat.parse(strTargetStartDate);
			targetEndDate = simpleDateFormat.parse(strTargetEndDate);
		} catch (Exception ex) {
			return RuleRelationEnum.UNKNOWN;
		}
     		
        DateValueRangeConditionChecker conditionChecker = new DateValueRangeConditionChecker(srcStartDate, srcEndDate);
        ValueRange<Date, Date> targetValueRange = new ValueRange<Date, Date>(targetStartDate, targetEndDate);
        RuleRelationEnum relationEnum = conditionChecker.compare(targetValueRange);
		return relationEnum;
	}

	@Override
	public List<String> getValue() {
		return value;
	}

	@Override
	public void setValue(List<String> value) {
		this.value = value;
	}

}
