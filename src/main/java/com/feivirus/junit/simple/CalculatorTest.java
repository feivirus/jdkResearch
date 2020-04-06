package com.feivirus.junit.simple;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * @author feivirus
 */
public class CalculatorTest {
    private static Calculator calculator;

    @Before
    public void before() {
        System.out.println("测试新方法");
    }

    @BeforeClass
    public static void beforeTest() {
        if (calculator == null) {
            calculator = new Calculator();
        }
    }

    @Ignore
    @Test(timeout = 100)
    public void testAdd() {
        int result = calculator.add(2, 3);
        Assert.assertEquals(5, result);
        assertThat(result, is(5));
    }

    @Test
    public void testMinus() {
        int result = calculator.minus(5, 1);
        assertThat("minus is wrong", result, is(4));
    }

    @Test(expected = java.lang.ArithmeticException.class)
    //@Test
    public void testDivide() {
        int result = calculator.divide(8, 0);
        assertThat("hello", result, any(Integer.TYPE));
        assertThat("divide is wrong", result, is(4));
    }
}
