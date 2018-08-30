package com.feivirus.instruction.operand;

import com.feivirus.instruction.Operand;
import com.feivirus.instruction.InstructionStaticFactory;
import com.feivirus.instruction.RelationalInstruction;
import com.feivirus.instruction.enums.OperandEnum;
import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 
 * @author feivirus
 *
 */
public class IntegerOperand implements Operand<Integer> {
	private Integer value;

	@Override
	public Integer value() {
		return value;
	}

	@Override
	public OperandEnum type() {
		return OperandEnum.INTEGER;
	}

	@Override
	public Operand parse(Object... object) {
		if (object == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		if (object.length == 1)  {
			if(object[0] instanceof String) {
				value = Integer.valueOf((String)object[0]);
			}
			
			if (object[0] instanceof Integer) {
				value = Integer.valueOf((int)object[0]);
			}
		}  
		return this;
	}	
}
