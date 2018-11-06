package com.feivirus.lambda;

import org.junit.Before;
import org.junit.Test;

public class LambdaTest {
	private Lambda lambda;
	
	@Before
	public void initLambda() {
		if (lambda == null) {
			lambda = new Lambda();
		}
	}
	
	@Test
	public void testLambdaSample() {
		lambda.lambdaSample();
	}
	
	@Test
	public void testFunctionalInterface() {
		lambda.functionalInterface();
	}
	
	@Test
	public void testJDKLib() {
		lambda.testPredicate();
		lambda.testConsumer();
		lambda.testFunction();
	}
}
