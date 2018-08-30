package com.feivirus.instruction.impl;

import java.util.Date;

import com.feivirus.instruction.Operand;
import com.feivirus.instruction.RelationalInstruction;
import com.feivirus.instruction.enums.OperatorEnum;
import com.feivirus.instruction.operand.ValueRangeOperand;

public class ValueRangeDateBetweenInstruction<P extends ValueRangeOperand<T, ?> , T extends Date> implements RelationalInstruction<P, T>{

	@Override
	public boolean match(P sourceOperand, T targetValue, OperatorEnum operatorEnum) {
		Operand<T> firstOperand = sourceOperand.getFirstOperand();
		Operand<T> secondOperand = sourceOperand.getSecondOperand();
		
		if (operatorEnum == OperatorEnum.BETWEEN) {
			if (firstOperand.value() instanceof Date && 
				targetValue instanceof Date &&
				secondOperand.value() instanceof Date) {
				boolean lowerLimit = new DateLessThanInstruction().match(firstOperand.value(), targetValue, OperatorEnum.LT);
				boolean upperLimit =new DateGreaterThanInstruction().match(secondOperand.value(), targetValue, OperatorEnum.GT);
				
				if (upperLimit && lowerLimit) {
					return true;
				}
			}
		} 
		return false;
	}
}
