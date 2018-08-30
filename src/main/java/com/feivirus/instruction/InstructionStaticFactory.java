package com.feivirus.instruction;

import com.feivirus.instruction.enums.OperandEnum;
import com.feivirus.instruction.enums.OperatorEnum;
import com.feivirus.instruction.impl.NumberEqualInstruction;
import com.feivirus.instruction.impl.ValueRangeNumberBetweenInstruction;
import com.feivirus.instruction.operand.IntegerOperand;
import com.feivirus.instruction.operand.ValueRangeOperand;

/**
 * 
 * @author feivirus
 *
 */
public class InstructionStaticFactory {
	/**
	 * 本来想用泛型的，没想起来怎么转换.omg
	 * @param operatorEnum
	 * @return
	 */
	public static Object createInstruction(OperatorEnum operatorEnum, OperandEnum operandEnum) {
		if (operatorEnum == null) {
			return null;
		}
		if (operatorEnum == OperatorEnum.EQ && 
			operandEnum == OperandEnum.INTEGER) {
			return new NumberEqualInstruction<Integer, Integer>();
			
		} else if (operatorEnum == OperatorEnum.EQ && 
			operandEnum == OperandEnum.DOUBLE) {
			return new NumberEqualInstruction<Double, Double>();
			
		} else if (operatorEnum == OperatorEnum.BETWEEN && 
			operandEnum == OperandEnum.VALUE_RANCE_INTEGER) {
			return new ValueRangeNumberBetweenInstruction<ValueRangeOperand<Integer, IntegerOperand>, Integer>();
			
		}
		return null;
	}
}
