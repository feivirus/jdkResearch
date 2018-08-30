package com.feivirus.instruction.impl;

import java.util.Date;

import com.feivirus.instruction.RelationalInstruction;
import com.feivirus.instruction.enums.OperatorEnum;

public class DateLessThanInstruction implements RelationalInstruction<Date, Date>{
	@Override
	public boolean match(Date sourceOperand, Date targetValue, OperatorEnum operatorEnum) {
		if (operatorEnum == OperatorEnum.LT) {
			return sourceOperand.before(targetValue);
		}
		return false;
	}
}
