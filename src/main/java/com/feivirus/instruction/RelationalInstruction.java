package com.feivirus.instruction;

import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 *  关系运算符，比如==,!=, <,>, in
 */
public interface RelationalInstruction<P, T> {
	//匹配
	boolean match(P sourceOperand, T targetValue, OperatorEnum operatorEnum);	
}
