package com.feivirus.exam;

/**
 * @author feivirus
 */
public class TestOperatorOrder {
    public static void main(String[] args) {
        int num = 50;
        num = num++ * 2;
        System.out.println(num);
        /**
         *num = 50
         *num_x = num + 1
         *num = num * 2
         *
         */
    }
}
