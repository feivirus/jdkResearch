package com.feivirus.caculator;

import com.feivirus.caculator.intermediatecaculator.Operand;

public enum CaculatorOperandEnum {
	INTEGER(1) {
		@Override
		public Operand getInstance() {
			return null;
		}
	},
	
	DOUBLE(2) {
		@Override
		public Operand getInstance() {
			return null;
		}
	},
	
	STRING(3) {
		@Override
		public Operand getInstance() {
			return null;
		}
	},

	DATE(4) {
		@Override
		public Operand getInstance() {
			return null;
		}
	};

   private Integer value;
   
   private CaculatorOperandEnum(Integer value) {
	   this.value = value;
   }
   
   public abstract Operand getInstance();
}
