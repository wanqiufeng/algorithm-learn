package com.vincent.algorithm.basic.array;

public class RotateMatrix {

    /**https://www.youtube.com/watch?v=6hXLJF7aOiM&t=214s
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++) {
            for(int j=i;j<n-1-i;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-j][i];
            }
        }
    }
}
