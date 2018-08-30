package com.feivirus.instruction.impl;

import com.feivirus.instruction.RelationalInstruction;
import com.feivirus.instruction.enums.OperatorEnum;
import com.feivirus.instruction.util.NumberUtil;

public class NumberLessThanInstruction<T extends Number, P extends Number> implements RelationalInstruction<P, T>{

	@Override
	public boolean match(P sourceOperand, T targetValue, OperatorEnum operatorEnum) {
		if (NumberUtil.isNumber(sourceOperand, targetValue) && 
			 operatorEnum == OperatorEnum.LT) {
				double sourceDoubleValue = NumberUtil.toDouble(sourceOperand);
				double targetDoubleValue = NumberUtil.toDouble(targetValue);
				return  sourceDoubleValue < targetDoubleValue;
			}
		return false;
	}	
}
