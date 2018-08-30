package com.feivirus.instruction;

import org.junit.Assert;
import org.junit.Test;

import com.feivirus.instruction.enums.OperandEnum;
import com.feivirus.instruction.enums.OperatorEnum;

public class InstructionTest {
	/**
	 * 规则匹配
	 */
	@Test
	public void testRuleMatch() {		
		Operand<Integer> operand = new OperandFacade<Integer>(OperandEnum.INTEGER).parse("20", "lt", "gt", "50");
		ExpressionManager<Integer> expressionManager = new ExpressionManager<Integer>(OperatorEnum.BETWEEN, operand);
				
		Assert.assertTrue(expressionManager.match(30));		
	}
}
