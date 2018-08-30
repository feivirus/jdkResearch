package com.feivirus.instruction.impl;

import com.feivirus.instruction.RelationalInstruction;
import com.feivirus.instruction.enums.OperatorEnum;

public class NumberEqualInstruction<P, T extends Number> implements RelationalInstruction<P, T>{

	@Override
	public boolean match(P sourceOperand, T targetValue, OperatorEnum operatorEnum) {
		if (sourceOperand instanceof Number && 
			 targetValue instanceof Number &&
			 operatorEnum == OperatorEnum.EQ) {
			 	return sourceOperand.equals(targetValue);
		}
		return false;
	}	
}
