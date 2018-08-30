package com.feivirus.instruction;

import com.feivirus.instruction.enums.OperandEnum;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 */
public interface Operand<T> {

	//解析格式
	Operand parse(Object... object);
	
	//如果多个值时，解析为List<RuleOperand>
	T value();
	
	//返回操作数类型
	OperandEnum type();
}
