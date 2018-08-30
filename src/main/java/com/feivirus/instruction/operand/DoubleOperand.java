package com.feivirus.instruction.operand;

import com.feivirus.instruction.Operand;
import com.feivirus.instruction.enums.OperandEnum;

public class DoubleOperand implements Operand<Double>{
	private Double value;

	@Override
	public Double value() {
		return value;
	}

	@Override
	public OperandEnum type() {
		return OperandEnum.DOUBLE;
	}

	@Override
	public Operand parse(Object... object) {
		if (object == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		if (object.length == 1)  {
			if(object[0] instanceof String) {
				value = Double.valueOf((String)object[0]);
			}
			
			if (object[0] instanceof Double) {
				value = Double.valueOf((double)object[0]);
			}
		}  
		return null;
	}
}
