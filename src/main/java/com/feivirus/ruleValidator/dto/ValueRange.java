package com.feivirus.ruleValidator.dto;

import com.feivirus.ruleValidator.base.RuleRelationEnum;

/**
 * 
 * @author feivirus
 *
 * @param <S>
 * @param <E>
 */
public class ValueRange<S, E> {
	protected S start;
	
	protected E end;

	public ValueRange (S s, E e) {
		this.start = s;
		this.end = e;
	}
	
	public S getStart() {
		return start;
	}

	public void setStart(S start) {
		this.start = start;
	}

	public E getEnd() {
		return end;
	}

	public void setEnd(E end) {
		this.end = end;
	}	
	
	public <T extends Number> RuleRelationEnum compare(ValueRange<T, T> src, ValueRange<T, T> target) {
		if (src == null && target == null) {
			return RuleRelationEnum.UNKNOWN;
		}
		if (src == null) {
			return RuleRelationEnum.CONTAIN;
		}
		if (src.getStart() == null && src.getEnd() == null) {
			return RuleRelationEnum.CONTAIN;
		}
		if (target == null) {
			return RuleRelationEnum.SUBSET;
		}
		if (target.getStart() == null && target.getEnd() == null) {
			return RuleRelationEnum.SUBSET;
		}
		
		double srcStart = src.getStart().doubleValue();
		double srcEnd = src.getEnd().doubleValue(); 
		double targetStart = target.getStart().doubleValue();
		double targetEnd = target.getEnd().doubleValue();
		
		if (srcStart == 0 && srcEnd == 0) {
			return RuleRelationEnum.CONTAIN;
		}
		
		if (targetStart == 0 && targetEnd == 0) {
			return RuleRelationEnum.SUBSET;
		}
		
		if (srcStart == targetStart && srcEnd == targetEnd) {
			return RuleRelationEnum.EQUAL;
		}
		
		//a1 b1 a2 b2格式
		if (srcStart <= targetStart && srcEnd <= targetEnd && targetStart <= srcEnd) {
			return RuleRelationEnum.INTERSECT;
		}
		
		//b1 a1 b2 a2格式
		if (targetStart <= srcStart && srcStart <= targetEnd && targetEnd <= srcEnd) {
			return RuleRelationEnum.INTERSECT;
		}
		
		//a1 a2 b1 b2格式
		if (srcEnd <= targetStart) {
			return RuleRelationEnum.SEPARATE;
		}
		
		//b1 a1 a2 b2格式
		if (targetStart <= srcStart && srcEnd <= targetEnd) {
			return RuleRelationEnum.SUBSET;
		}
		
		////b1 b2 a1 a2格式
		if (targetEnd < srcStart) {
			return RuleRelationEnum.SEPARATE;
		}
		return RuleRelationEnum.UNKNOWN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueRange other = (ValueRange) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}		
}
