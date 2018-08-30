package com.feivirus.instruction.impl;

import com.feivirus.instruction.Operand;
import com.feivirus.instruction.RelationalInstruction;
import com.feivirus.instruction.enums.OperatorEnum;
import com.feivirus.instruction.operand.ValueRangeOperand;

public class ValueRangeNumberBetweenInstruction<P extends ValueRangeOperand<T, ?> , T extends Number> implements RelationalInstruction<P, T>{

	@Override
	public boolean match(P sourceOperand, T targetValue, OperatorEnum operatorEnum) {
		Operand<T> firstOperand = sourceOperand.getFirstOperand();
		Operand<T> secondOperand = sourceOperand.getSecondOperand();
		
		if (operatorEnum == OperatorEnum.BETWEEN) {
			if (firstOperand.value() instanceof Number && 
				targetValue instanceof Number &&
				secondOperand.value() instanceof Number) {
				boolean lowerLimit = new NumberLessThanInstruction<T, T>().match(firstOperand.value(), targetValue, OperatorEnum.LT);
				boolean upperLimit =new NumberGreaterThanInstruction<T, T>().match(secondOperand.value(), targetValue, OperatorEnum.GT);
				
				if (upperLimit && lowerLimit) {
					return true;
				}
			}
		} 
		return false;
	}
}
