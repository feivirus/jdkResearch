package com.feivirus.instruction;

import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 
 * @author feivirus
 *
 * @param <T>
 * 
 * 表达式由操作符+操作数+操作指令组成.
 * 目前只支持返回布尔类型的指令运算，不支持加减乘除的返回数据类型相同的运算
 */
public class ExpressionManager<T>{
	private static final long serialVersionUID = 2460398928433780544L;
	
	//操作符
	private OperatorEnum operatorEnum;
	
	//条件内的目标操作数
	private Operand<T> sourceOperand;		

	public ExpressionManager(OperatorEnum operatorEnum, Operand<T> sourceOperand) {
		super();
		this.operatorEnum = operatorEnum;
		this.sourceOperand = sourceOperand;
	}

	public OperatorEnum getOperatorEnum() {
		return operatorEnum;
	}

	public void setOperatorEnum(OperatorEnum operatorEnum) {
		this.operatorEnum = operatorEnum;
	}

	public Operand<T> getSourceOperand() {
		return sourceOperand;
	}

	public void setSourceOperand(Operand<T> sourceOperand) {
		this.sourceOperand = sourceOperand;
	}

	public boolean match(T targetOperand) {
		RelationalInstruction<T, T> instruction = (RelationalInstruction)InstructionStaticFactory.createInstruction(operatorEnum, 
				sourceOperand.type());
		boolean ret = false;
		
		if (instruction != null) {
			ret =  instruction.match(sourceOperand.value(), targetOperand, operatorEnum);
		}
		return ret;
	}
}
