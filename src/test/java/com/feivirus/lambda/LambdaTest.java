package com.feivirus.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.feivirus.lambda.reason.Apple;

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
	public void testConstructAppleWithIntegerList() {
		List<Integer> valueList = Arrays.asList(1, 2, 3, 4);
		List<Apple> appleList = lambda.constructAppleWithIntegerList(valueList, Apple::new);
	}
}
