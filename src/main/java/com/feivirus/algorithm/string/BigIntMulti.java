package com.feivirus.algorithm.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author feivirus
 * 两个大数相乘
 */
public class BigIntMulti {

    public static void main(String[] args) {
        BigIntMulti multi = new BigIntMulti();

        System.out.println("result:" + multi.multi("12345", "147"));
    }

    /**
     *
     * @param firstNumber
     * @param secondNumber
     * @return
     *  123
     *   14
     * ----
     *  492
     * 123
     * 1722
     * 1.先算每位上的乘法
     * 2.再算大整数相加
     */
    public String multi(String firstNumber, String secondNumber) {
        if (StringUtils.isBlank(firstNumber) ||
            firstNumber.equals("0")) {
            return secondNumber;
        }
        if (StringUtils.isBlank(secondNumber) ||
            secondNumber.equals("0")) {
            return firstNumber;
        }

        String result = "";
        boolean isFirstLonger = firstNumber.length() >= secondNumber.length();
        String longNumber = "", shortNumber = "";

        if (isFirstLonger) {
            longNumber = firstNumber;
            shortNumber = secondNumber;
        } else {
            longNumber = secondNumber;
            shortNumber = firstNumber;
        }

        StringBuffer oneLoopResult = new StringBuffer("");
        int bitCount = 0;
        BigIntAdder adder = new BigIntAdder();

        for(int i = shortNumber.length() - 1; i >= 0; i--) {
            int shortNumberBit = shortNumber.charAt(i) - '0';

            oneLoopResult = new StringBuffer("");
            int carry = 0;

            for(int j = longNumber.length() - 1; j >= 0; j--) {
                int longNumberBit = longNumber.charAt(j) - '0';
                int oneBitResult = shortNumberBit * longNumberBit;

                if (carry != 0) {
                    oneBitResult += carry;
                }

                if (oneBitResult >= 10) {
                    carry = oneBitResult / 10;
                    oneBitResult = oneBitResult % 10;
                } else {
                    carry = 0;
                }

                oneLoopResult.insert(0, oneBitResult);
            }

            for(int k = 0; k < bitCount; k++) {
                oneLoopResult.append('0');
            }
            result = adder.add(result, oneLoopResult.toString());
            bitCount++;
        }

        return result;
    }
}
