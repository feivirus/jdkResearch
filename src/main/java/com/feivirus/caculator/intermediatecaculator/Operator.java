package com.feivirus.caculator.intermediatecaculator;

public interface Operator {
	void setLeftOperand(Operand operand);
	
	void setRightOperand(Operand operand);
	
	Object eval();
}
