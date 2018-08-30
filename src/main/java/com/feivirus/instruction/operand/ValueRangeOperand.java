package com.feivirus.instruction.operand;

import com.feivirus.instruction.Operand;
import com.feivirus.instruction.enums.OperandEnum;
import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 * @param <P>
 */
public class ValueRangeOperand<T, P extends Operand> implements Operand<ValueRangeOperand<T, P>>{
	private P firstOperand;
	
	private OperatorEnum firstOperatorEnum;
	
	private OperatorEnum secondOperatorEnum;
	
	private P secondOperand;		

	@Override
	public Operand parse(Object... object) {
		if (object == null) {
			return null;
		}
		if (object.length == 4) {
			firstOperand = (P)object[0];
			firstOperatorEnum = (OperatorEnum)object[1];
			secondOperatorEnum = (OperatorEnum)object[2];
			secondOperand = (P)object[3];
		}		
		return this;
	}

	@Override
	public OperandEnum type() {
		if (firstOperand instanceof IntegerOperand) {
			return OperandEnum.VALUE_RANCE_INTEGER;
		} else if (firstOperand instanceof DoubleOperand) {
			return OperandEnum.VALUE_RANGE_DOUBLE;
		}
		return null;
	}	
	
	@Override
	public ValueRangeOperand<T, P> value() {
		return this;
	}

	public P getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(P firstOperand) {
		this.firstOperand = firstOperand;
	}

	public OperatorEnum getFirstOperatorEnum() {
		return firstOperatorEnum;
	}

	public void setFirstOperatorEnum(OperatorEnum firstOperatorEnum) {
		this.firstOperatorEnum = firstOperatorEnum;
	}

	public OperatorEnum getSecondOperatorEnum() {
		return secondOperatorEnum;
	}

	public void setSecondOperatorEnum(OperatorEnum secondOperatorEnum) {
		this.secondOperatorEnum = secondOperatorEnum;
	}

	public P getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(P secondOperand) {
		this.secondOperand = secondOperand;
	}
}
