package com.feivirus.caculator.intermediatecaculator;

import com.feivirus.caculator.CaculatorOperandEnum;

public interface Operand<T> {
	
	CaculatorOperandEnum getType();
	
	T value();
	
	Object parse(Object... objects);
}
