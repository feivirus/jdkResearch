package com.feivirus.algorithm.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author feivirus
 * 两个大数相加
 */
public class BigIntAdder {

    public static void main(String[] args) {
        BigIntAdder adder = new BigIntAdder();

        System.out.println("result:" + adder.add("1234567", "1234567890"));
    }

    /**
     * 两个大数相加，不是数字，返回空串
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    private String add(String firstNumber, String secondNumber) {
        if (StringUtils.isEmpty(firstNumber) ||
                firstNumber.equals("0")) {
            return secondNumber;
        }
        if (StringUtils.isEmpty(secondNumber) ||
                secondNumber.equals("0")) {
            return firstNumber;
        }

        int minLength = firstNumber.length() >= secondNumber.length() ? secondNumber.length() : firstNumber.length();
        StringBuffer result = new StringBuffer("");
        boolean carry = false;
        int oneBitResult = 0;
        boolean isFirstMax = firstNumber.length() > secondNumber.length();

        for(int i = minLength - 1; i >= 0; i--) {
            char firstChar = '0';
            char secondChar = '0';

            if (isFirstMax) {
                firstChar = firstNumber.charAt(firstNumber.length() - secondNumber.length() + i);
                secondChar = secondNumber.charAt(i);
            } else {
                firstChar = firstNumber.charAt(i);
                secondChar = secondNumber.charAt(secondNumber.length() - firstNumber.length() + i);
            }

            if (firstChar > '9' ||
                firstChar < '0' ||
                secondChar > '9' ||
                secondChar < '0') {
                return "";
            }

            oneBitResult = firstChar - '0' + secondChar - '0';
            if (carry) {
                oneBitResult += 1;
            }

            if (oneBitResult >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            oneBitResult = oneBitResult % 10;
            result.insert(0, oneBitResult);
        }

        boolean isSecondMax = firstNumber.length() < secondNumber.length();
        boolean firstCarry = true;

        if (isFirstMax) {
            for(int i = firstNumber.length() - minLength - 1; i >= 0; i--) {
                char firstChar = firstNumber.charAt(i);

                if (firstChar > '9' ||
                    firstChar < '0') {
                    return "";
                }
                oneBitResult = firstChar - '0';

                if (firstCarry && carry) {
                    oneBitResult += 1;
                    firstCarry = false;
                }
                result.insert(0, oneBitResult);

            }
        }
        if (isSecondMax) {
            for(int i = secondNumber.length() - minLength - 1; i >= 0; i--) {
                char sencondChar = secondNumber.charAt(i);

                if (sencondChar > '9' ||
                    sencondChar < '0') {
                    return "";
                }
                oneBitResult = sencondChar - '0';

                if (firstCarry && carry) {
                    oneBitResult += 1;
                    firstCarry = false;
                }
                result.insert(0, oneBitResult);
            }
        }

        return result.toString();
    }
}
