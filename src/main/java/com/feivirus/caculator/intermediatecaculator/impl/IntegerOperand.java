package com.feivirus.caculator.intermediatecaculator.impl;

import com.feivirus.caculator.CaculatorOperandEnum;
import com.feivirus.caculator.intermediatecaculator.Operand;

public class IntegerOperand implements Operand<Integer> {
	private Integer value;

	@Override
	public Integer value() {
		return value;
	}

	@Override
	public Object parse(Object... objects) {
		if (objects.length == 1) {
			Object tempValue = objects[0];
			
			if (tempValue instanceof String) {
				value = Integer.valueOf(tempValue.toString());
			} else if (tempValue instanceof Integer) {
				value = (Integer)tempValue;
			}
		}
		return value;
	}

	@Override
	public CaculatorOperandEnum getType() {
		return CaculatorOperandEnum.INTEGER;
	}
	
}
