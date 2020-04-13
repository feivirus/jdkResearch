package com.feivirus.algorithm.dynamicplan.bagproblem;

/**
 * @author feivirus
 * 背包问题
 */
public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] values = {60, 100, 120};

        int weightLimit = 50;
        int maxCount = 3;
        int[][] dpValues = new int[maxCount + 1][weightLimit + 1];

        for(int i = 1; i <= maxCount; i++) {
            for(int currentWeight = 1; currentWeight <= weightLimit; currentWeight++ ) {
                if (weight[i - 1] <= currentWeight) {
                    //如果添加新物品的价值
                    int addedValue = values[i - 1] + dpValues[i - 1][currentWeight - weight[i - 1]];
                    //如果不添加新物品的价值
                    int notAddedValue = dpValues[i - 1][currentWeight];
                    if (addedValue > notAddedValue) {
                        dpValues[i][currentWeight] = addedValue;
                    } else {
                        dpValues[i][currentWeight] = notAddedValue;
                    }
                } else {
                    //不添加新物品，容积不够
                    dpValues[i][currentWeight] = dpValues[i - 1][currentWeight];

                }
            }
        }

        System.out.println("能装的最大值为 " + dpValues[maxCount][weightLimit]);
    }
}
