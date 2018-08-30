package com.feivirus.instruction.enums;

import com.feivirus.instruction.Operand;
import com.feivirus.instruction.operand.DateOperand;
import com.feivirus.instruction.operand.DoubleOperand;
import com.feivirus.instruction.operand.IntegerOperand;
import com.feivirus.instruction.operand.ValueRangeOperand;

public enum OperandEnum {
	INTEGER(1) {
		@Override
		public Operand getInstance() {
			return new IntegerOperand();
		}		
	},
	DOUBLE(2) {
		@Override
		public Operand getInstance() {			
			return new DoubleOperand();
		}		
	},
	VALUE_RANCE_INTEGER(3) {
		@Override
		public Operand getInstance() {
			// TODO Auto-generated method stub
			return new ValueRangeOperand<Integer, IntegerOperand>();
		}
	},
	VALUE_RANGE_DOUBLE(4) {
		@Override
		public Operand getInstance() {
			return new ValueRangeOperand<Double, DoubleOperand>();
		}
	},
	DATE(5) {
		@Override
		public Operand getInstance() {
			// TODO Auto-generated method stub
			return new  DateOperand();
		}		
	};	
	
	private int value;

	OperandEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}	
	
	public abstract Operand getInstance();
}
