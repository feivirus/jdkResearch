package com.feivirus.algorithm.string;

/**
 *
 * @author feivirus
 * 对由010101等组成的字串排序，排序成000111
 */
public class SortBinaryString {

    public static void main(String[] args) {
        SortBinaryString sortBinaryString = new SortBinaryString();
        String result = sortBinaryString.sort("010101");
        System.out.println("result: " + result);
    }

    public String sort(String binaryString) {
        int length = binaryString.length();
        int start = 0, end = length - 1;
        char startChar, endChar;
        StringBuffer result = new StringBuffer(binaryString);

        while (start < end) {
            do {
                startChar = (char)binaryString.charAt(start);
                start++;
            } while (startChar == '0' && start < end);

            do {
                endChar = (char)binaryString.charAt(end);
                end--;
            } while (endChar == '1' && start < end);

            if (start < end) {
                result.setCharAt(start - 1, '0');
                result.setCharAt(end + 1, '1');
            }
        }

        return result.toString();
    }
}
