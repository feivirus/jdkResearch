package com.feivirus.instruction;

import com.feivirus.instruction.enums.OperandEnum;
import com.feivirus.instruction.enums.OperatorEnum;
import com.feivirus.instruction.operand.IntegerOperand;
import com.feivirus.instruction.operand.ValueRangeOperand;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 * @param <P>
 * 做多参数转换
 */
public class OperandFacade<T> implements Operand<T>{
	 Operand<T> ruleOperand;	
	 
	 //用于普通数据类型的衍生类型，比如区间类型,判断区间的数据类型是Integer,还是String等
	 OperandEnum typeEnum;

	public OperandFacade(OperandEnum typeEnum) {
		ruleOperand = typeEnum.getInstance();		
		this.typeEnum = typeEnum;
	}
	 
	 /**
	  * 多个参数解析到具体RuleOperand中,比如ValueRange类型的
	  * @param object
	  * @return
	  */
	@Override
	public Operand parse(Object... object) {
		if (object == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
		if (object.length == 1) {
			ruleOperand.parse(object);
		} else if (object.length == 4) {
			ruleOperand = parseValueRangeArgument(object);
		}
		
		return ruleOperand;
	}	
	
	public Operand parseValueRangeArgument(Object[] objects) {
		if (typeEnum == OperandEnum.INTEGER) {
			Operand<Integer>  firstOperand = new IntegerOperand().parse(objects[0]);
			OperatorEnum firstOperator = OperatorEnum.getEnumByCode(objects[1].toString());
			OperatorEnum secondOperator = OperatorEnum.getEnumByCode(objects[2].toString());
			Operand<Integer> secondOperand = new IntegerOperand().parse(objects[3]);
			
			Object[] newParameter = new Object[4];
			newParameter[0] = firstOperand;
			newParameter[1] = firstOperator;
			newParameter[2] = secondOperator;
			newParameter[3] = secondOperand;
			return new ValueRangeOperand<Integer, IntegerOperand>().parse(newParameter);
		}
		return null;
	}

	@Override
	public T value() {
		return ruleOperand.value();
	}

	@Override
	public OperandEnum type() {
		// TODO Auto-generated method stub
		return null;
	}
}
