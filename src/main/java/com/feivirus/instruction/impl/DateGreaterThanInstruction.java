package com.feivirus.instruction.impl;

import java.util.Date;
import com.feivirus.instruction.RelationalInstruction;
import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 
 * @author feivirus
 *
 */
public class DateGreaterThanInstruction implements RelationalInstruction<Date, Date>{

	@Override
	public boolean match(Date sourceOperand, Date targetValue, OperatorEnum operatorEnum) {
		if (operatorEnum == OperatorEnum.GT) {
			return sourceOperand.after(targetValue);
		}
		return false;
	}

}
