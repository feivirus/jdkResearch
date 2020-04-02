package com.feivirus.algorithm.array;

/**
 * @author feivirus
 * 求连通的最大黑色面积 leetcode 85
 */
public class MaxConnectAreaFinder {

    private final Integer BLACK = 1;

    private final Integer VISITED = -1;


    public static void main(String[] args) {
        int[][] area = {{0,1,1,0}, {0,1,0,0},{0,1,1,0}};
        MaxConnectAreaFinder finder = new MaxConnectAreaFinder();

        int result = finder.findMaxConnectArea(area);
        System.out.println("result: " + result);
    }

    /**
     * 求最大联通黑色区域
     *
     * @param area 原始区域
     * @return
     */
    public int findMaxConnectArea(final int[][] area) {
        if (area == null ||
            area[0] == null ||
            area[0].length == 0) {
            return 0;
        }

        int rowCount = area.length;
        int columnCount = area[0].length;
        int result = 0;
        int onceResult = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (!BLACK.equals(area[i][j])) {
                    continue;
                }

                onceResult = findOneElementArea(area, i, j);
                if (onceResult > result) {
                    result = onceResult;
                }
            }
        }
        
        return result;
    }

    /**
     * 寻找一个节点的连通个数
     *
     * @param area   连通区域
     * @param row    行索引
     * @param column 列索引
     *               1.先判断当前节点是否是黑色节点
     *               2.再依次遍历右边,左边,上边,下边元素
     */
    private int findOneElementArea(int[][] area, int row, int column) {
        if (row < 0 ||
            row >= area.length) {
            return 0;
        }
        if (column < 0 ||
            column >= area[0].length) {
            return 0;
        }
        if (!BLACK.equals(area[row][column])) {
            return 0;
        }
        
        area[row][column] = VISITED;
        int result = 1;

        result += findOneElementArea(area, row, column + 1);
        result += findOneElementArea(area, row, column - 1);
        result += findOneElementArea(area, row - 1, column);
        result += findOneElementArea(area, row + 1, column);
        return result;
    }
}
