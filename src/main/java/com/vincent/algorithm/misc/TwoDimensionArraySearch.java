package com.vincent.algorithm.misc;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *  
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TwoDimensionArraySearch {
    //结题思路
    //由于数组列递增。从第一列即可判断这一行是否值得进一步判断。
    //由于数组行是递增，从上述定位的某行，的最后一个元素，即可判定该行是否值得进一步判断
    public static void main(String[] args) {
        int[][] data = new int[][]{{}};
        int searchValue = 5;

        boolean result = hasSearchValue(data,searchValue);
    }

    private static int[][] prepareData() {
        return new int[0][];
    }

    private static boolean hasSearchValue(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length ==0){
            return false;
        }
        for(int i=0;i< matrix.length;i++) {
            if(matrix[i][0] > target) {
                return false;
            }
            if(matrix[i][0] == target) {
                return true;
            }

            int secondDimensionArrayLength = matrix[i].length;
            if(matrix[i][secondDimensionArrayLength-1] <target) {
                continue;
            }
            for(int j = 1; j<secondDimensionArrayLength; j++) {
                if(matrix[i][j]<target) {
                    continue;
                }
                if(matrix[i][j]==target) {
                    return true;
                }
                break;
            }
        }

        return false;
    }
}
