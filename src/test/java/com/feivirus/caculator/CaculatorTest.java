package com.feivirus.caculator;

import org.junit.Assert;
import org.junit.Test;

import com.feivirus.caculator.intermediatecaculator.Operand;
import com.feivirus.caculator.intermediatecaculator.Operator;
import com.feivirus.caculator.intermediatecaculator.impl.AddOperator;
import com.feivirus.caculator.intermediatecaculator.impl.IntegerOperand;
import com.feivirus.caculator.simplecaculator.SimpleCaculator;
import com.feivirus.instruction.enums.OperatorEnum;

/**
 * 计算器需求
 * @author feivirus
 * 一. 整数相加 单方法
 * 二. 整数加减乘除 if 匹配操作符
 * 三. 数字的加减乘除 泛型
 * 四. 基于操作符/操作数计算
 * 五. 指令/表达式系统(单操作符)
 * 六. 词法/语法分析(多操作符)
 * 七. 规则引擎 drools
 */

public class CaculatorTest {
	
	@Test
	public void testSimpleCaculator() {
			
	}
	
	/**
	 * 需求一 整数相加
	 */
	@Test
	public void demand1() {
		SimpleCaculator caculator = new SimpleCaculator();
		
		Integer result = caculator.add(1, 2, '+');
		System.out.println(result);
	}	
	
	/**
	 * 需求二 整数加减乘除
	 */
	@Test
	public void demand2() {
		SimpleCaculator simpleCaculator = new SimpleCaculator();
		Integer a = 1, b = 2;
		
		Integer resultInteger = simpleCaculator.compute(a, b, CaculatorOperatorEnum.MULTIPLY);		
		System.out.println(resultInteger);
	}
	
	/**
	 * 需求三 数字的加减乘除
	 */
	@Test
	public void demand3() {
		SimpleCaculator simpleCaculator = new SimpleCaculator();
		Double a = 1.1d;
		Integer b = 2;
		Double result = null;
		
		result = simpleCaculator.compute(a, b, CaculatorOperatorEnum.MINUS);
		System.out.println(result);
	}
	
	/**
	 * 需求四 基于操作符/操作数计算
	 */
	@Test
	public void demand4() {
		Operand leftOperand = new IntegerOperand();
		leftOperand.parse("10");
		
		Operand rightOperand = new IntegerOperand();
		rightOperand.parse("20");
		
		Operator addOperator = new AddOperator();
		addOperator.setLeftOperand(leftOperand);
		addOperator.setRightOperand(rightOperand);
		Object result = addOperator.eval();
		System.out.println(result);
	}
}
