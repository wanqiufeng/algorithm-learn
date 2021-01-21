package com.vincent.algorithm.basic.array;

/**
 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

 此外，你可以假设该网格的四条边均被水包围。

 

 示例 1：

 输入：grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 输出：1
 示例 2：

 输入：grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 输出：3
 

 提示：

 m == grid.length
 n == grid[i].length
 1 <= m, n <= 300
 grid[i][j] 的值为 '0' 或 '1'

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-islands
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfIslands {
    public static void main(String[] args) {

    }

    /**
    解题教程：极客时间中，覃超的算法培训课中有

     解题思路：
        1.就是从第一行开始遍历整个二维数组(两个for循环即可，第一层循环是行，第二层循环是列)
        2.如果发现遍历的当前位置是1，也即是岛屿。那么久以此位置开始上下左右的搜索，直到遇到0，或超出数组边界。 并在这个过程中将遇到的1，置位0
        3.之所以要将遇到的1，都置位0的原因是，让第一步中的for循环走到该位置时，不用再重复的搜索

        总结：整体的这个解题思路，叫染色法，又叫岛屿沉没法，因为把找到为1的也即是岛屿的地方置位了0
     解题注意事项：
        这个二维数组中存储的是字符，不是数字，主要判断的'1'和'0' 不是1和0

     */
    public int numIslands(char[][] grid) {
        if(grid == null||grid.length == 0) return 0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int islandsNumber = 0;
        for(int i=0;i<rowLength;i++) {
            for(int j=0;j<columnLength;j++) {
                if(grid[i][j] == '1') {
                    //如果当前位置是岛屿，那么开启搜索模式
                    islandsNumber++;
                    dfs(grid,i,j);
                }
            }
        }
        return islandsNumber;
    }

    private void dfs(char[][] grid, int i, int j) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        if(i>=rowLength|| j>=columnLength||i<0||j<0||grid[i][j]=='0') return;
        grid[i][j] = '0';//说明当前搜索的位置时岛屿，将该岛屿沉没
        dfs(grid,i-1,j);//基于当前位置向上搜索
        dfs(grid,i+1,j);//向下搜索
        dfs(grid,i,j-1);//向左搜索
        dfs(grid,i,j+1);//向右搜索
    }
}
