package com.feivirus.instruction.operand;

import java.util.Date;

import com.feivirus.instruction.Operand;
import com.feivirus.instruction.enums.OperandEnum;

public class DateOperand implements Operand<Date>{
	private Date value;

	@Override
	public Operand parse(Object... object) {
		if (object == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		if (object.length == 1)  {
			if(object[0] instanceof String) {
				
			}
			
			if (object[0] instanceof Date) {
				value = (Date)object[0];
			}
		}  
		return null;
	}

	@Override
	public Date value() {
		return value;
	}

	@Override
	public OperandEnum type() {		
		return OperandEnum.DATE;
	}
}
