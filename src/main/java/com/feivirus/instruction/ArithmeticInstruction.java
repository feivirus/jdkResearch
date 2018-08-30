package com.feivirus.instruction;

import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 */
public interface ArithmeticInstruction<T> {
	//算数运算符，比如加减乘除
	T eval(T sourceOperand, T targetOperand, OperatorEnum operatorEnum);	
}
