package com.feivirus.caculator.simplecaculator;

import com.feivirus.caculator.CaculatorOperatorEnum;
import com.feivirus.instruction.util.NumberUtil;

public class SimpleCaculator {
	
	//整数相加
	public Integer add(Integer a, Integer b, char symbol) {
		if((a == null) ||
			(b == null) ||
			 (symbol != '+')) {
			return null;
		}	
		
		Integer result = a + b;
		return result;
	}
	
	//整数加减乘除
	public Integer compute(Integer a, Integer b, CaculatorOperatorEnum operatorEnum) {
		if ((a == null) || 
			(b == null) || 
			operatorEnum == null) {
			return null;
		}
		
		if (operatorEnum == CaculatorOperatorEnum.ADD) {
			return a + b;
		} else if (operatorEnum == CaculatorOperatorEnum.MINUS) {
			return a - b;
		} else if (operatorEnum == CaculatorOperatorEnum.MULTIPLY) {
			return a * b;
		} else if (operatorEnum == CaculatorOperatorEnum.DIVIDE) {
			return a / b;
		}
		return null;
	}
	
	//数字加减乘除
	public <T, P> Double compute(T a, P b, CaculatorOperatorEnum operatorEnum) {
		if (a == null || 
			b == null || 
			operatorEnum == null) {
			return null;
		}
		
		if (a instanceof Number && 
			b instanceof Number) {
				if (operatorEnum == CaculatorOperatorEnum.ADD) {
					return NumberUtil.toDouble(a) + NumberUtil.toDouble(b);
				} else if (operatorEnum == CaculatorOperatorEnum.MINUS) {
					return NumberUtil.toDouble(a) - NumberUtil.toDouble(b);
				} else if (operatorEnum == CaculatorOperatorEnum.MULTIPLY) {
					return NumberUtil.toDouble(a) * NumberUtil.toDouble(b);
				} else if (operatorEnum == CaculatorOperatorEnum.DIVIDE) {
					return NumberUtil.toDouble(a) / NumberUtil.toDouble(b);
				}
		}

		return null;
	}
}
