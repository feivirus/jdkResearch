package com.feivirus.caculator.intermediatecaculator.impl;

import com.feivirus.caculator.intermediatecaculator.Operand;
import com.feivirus.caculator.intermediatecaculator.Operator;

public class AddOperator implements Operator {
	private Operand leftOperand;
	
	private Operand rightOperand;

	@Override
	public void setLeftOperand(Operand operand) {
		leftOperand = operand;
	}

	@Override
	public void setRightOperand(Operand operand) {
		rightOperand = operand;
	}

	@Override
	public Object eval() {
		if (leftOperand instanceof IntegerOperand &&
			rightOperand instanceof IntegerOperand) {
			IntegerOperand leftValue = (IntegerOperand)leftOperand;
			IntegerOperand rightValue = (IntegerOperand)rightOperand;
			
			return leftValue.value() + rightValue.value();
		}
		return null;
	}
}
