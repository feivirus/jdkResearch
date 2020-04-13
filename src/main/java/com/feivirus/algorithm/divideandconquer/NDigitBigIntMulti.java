package com.feivirus.algorithm.divideandconquer;

/**
 * @author feivirus
 * N位大整数相乘,乘数和被乘数都是N位.
 * 分治法解决
 */
public class NDigitBigIntMulti {

    public static void main(String[] args) {
        NDigitBigIntMulti multi = new NDigitBigIntMulti();
        int result = multi.multiply(123, 567, 3);
        System.out.println("result: " + result);
    }


    /**
     *
     * @param x
     * @param y
     * @param n 位数
     * @return
     */
    public int multiply(int x, int y, int n) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (n == 1) {
            return x * y;
        }

        int base = (int)Math.pow(10, n / 2);
        int A = x / base;
        int B = x - A * base;

        int C = y / base;
        int D = y - C * base;

        //x = A ~ B, y= C ~ D
        //result = A * C * power(10,n) + A * D * power(10, n/2) + B * C * power(10, n/2) + B * D
        int firstResult = multiply(A, C, n / 2);
        int secondResult = multiply(A, D, n / 2);
        int thirdResult = multiply(B, C, n / 2);
        int fourthResult = multiply(B, D, 1);
        double result = firstResult * Math.pow(10, n / 2 + n / 2) +
                secondResult * Math.pow(10, n / 2) +
                thirdResult * Math.pow(10, n / 2) +
                fourthResult;
        return (int)result;
    }
}
