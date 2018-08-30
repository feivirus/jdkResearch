package com.feivirus.instruction;

import java.io.Serializable;
import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 */
public interface Expression<P, T> extends Serializable, RelationalInstruction<P, T>{	
	//操作符
	OperatorEnum operator();
	
	//操作数
	Operand operand();
}
