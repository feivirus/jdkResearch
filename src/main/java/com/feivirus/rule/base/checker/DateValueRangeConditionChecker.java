package com.feivirus.rule.base.checker;

import java.util.Date;

import com.feivirus.rule.dto.ValueRange;
import com.feivirus.rule.base.RuleCondition;
import com.feivirus.rule.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 */
public class DateValueRangeConditionChecker extends ValueRange<Date, Date> implements RuleCondition<ValueRange<Date, Date>>{

	public DateValueRangeConditionChecker(Date s, Date e) {
		super(s, e);
	}

	@Override
	public RuleRelationEnum compare(ValueRange<Date, Date> target) {
		if ((start == null) && 
			(end == null) && 
			(target.getStart() == null) &&
			(target.getEnd() == null)) {
			return RuleRelationEnum.UNKNOWN;
		}
		if (start == null && end == null) {
			return RuleRelationEnum.CONTAIN;
		}
		if (target.getStart() == null &&
			target.getEnd() == null) {
			return RuleRelationEnum.SUBSET;
		}
		if (start.compareTo(target.getStart()) == 0 &&
			end.compareTo(target.getEnd()) == 0) {
			return RuleRelationEnum.EQUAL;
		}
		//日期为a1 b1 a2 b2格式
		if (!start.after(target.getStart()) &&
			!end.before(target.getEnd()) &&
			!start.after(target.getEnd())) {
			return RuleRelationEnum.INTERSECT;
		}
		//日期为a1 a2 b1 b2格式
		if (!end.after(target.getStart())) {
			return RuleRelationEnum.SEPARATE;
		}
		//日期为a1 b1 b2 a2格式
		if (!start.after(target.getStart()) &&
			!target.getEnd().after(end)) {
			return RuleRelationEnum.CONTAIN;
		}
		//日期为b1 a1 a2 b2格式
		if (!target.getStart().after(start) &&
			!end.after(target.getEnd())) {
			return RuleRelationEnum.SUBSET;
		}
		//日期为b1 b2 a1 a2格式
		if (!target.getEnd().after(start)) {
			return RuleRelationEnum.SEPARATE;
		}
		//日期为b1 a1 b2 a2格式
		if (!target.getStart().after(start) &&
			!target.getEnd().before(end) &&
			!start.after(target.getEnd())) {
			return RuleRelationEnum.INTERSECT;
		}		
		return null;
	}

	@Override
	public ValueRange<Date, Date> getValue() {
		ValueRange< Date, Date> valueRange = new ValueRange<Date, Date>(start, end);		
		return valueRange;
	}

	@Override
	public void setValue(ValueRange<Date, Date> value) {
		if (value != null) {
			start = value.getStart();
			end = value.getEnd();
		} else {
			start = null;
			end = null;
		}
	}

}
