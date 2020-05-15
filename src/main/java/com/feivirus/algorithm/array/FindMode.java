package com.feivirus.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author feivirus
 * 找出数组中出现次数超过一半的数,这个叫众数
 */
public class FindMode {

    public static void main(String[] args) {
        FindMode findMode = new FindMode();
        Integer[] values = {1, 2, 3, 5, 6, 2, 2, 2, 2};

        Integer result = findMode.findMode(values);
        System.out.println("result " + result);
    }

    public Integer findMode(Integer[] values) {
        int curPos = 1;
        List<Integer> valueList = new ArrayList<>(Arrays.asList(values));
        int size = valueList.size();

        if (size == 1) {
            return values[0];
        }

        for(int i = 0; i < size; i++) {

            if (valueList.size() == 1) {
                return valueList.get(0);
            }
            while (valueList.get(0).equals(valueList.get(curPos))) {
                curPos++;

                //防止数组越界
                if (curPos == valueList.size() - 1) {
                    break;
                }
            }
            if (!valueList.get(0).equals(valueList.get(curPos))) {
                valueList.remove(curPos);
                valueList.remove(0);
            }
            curPos = 1;
        }

        return valueList.get(0);
    }
}
