package com.feivirus.algorithm.array;

import java.util.BitSet;

/**
 * @author feivirus
 *
 * 找到第一个缺失的正整数(leetcode 41)
 * 找到从1开始第一个不在里面的正整数。
 * 比如[3,4,-1,1],输出2
 */
public class FindFirstMissingInt {
    public static void main(String[] args) {
        FindFirstMissingInt findFirstMissingInt = new FindFirstMissingInt();
        int[] values= {3,4,-1,1};

        Integer result = findFirstMissingInt.firstMissingInt(values);

        if (result != null) {
            System.out.println("result " + result);
        } else {
            System.out.println("result is null");
        }

    }

    public Integer firstMissingInt(int[] value) {
        int maxNumber = 100000000;
        int count = value.length;
        BitSet bitSet = new BitSet(maxNumber);

        for(int i = 0; i < count; i++) {
            if (value[i] >= 0) {
                bitSet.set(value[i]);
            }
        }

        for(int i = 1; i < maxNumber; i++) {
            if (!bitSet.get(i)) {
                return i;
            }
        }
        return null;
    }
}
