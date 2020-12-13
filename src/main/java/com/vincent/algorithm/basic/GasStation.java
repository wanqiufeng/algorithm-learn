package com.vincent.algorithm.basic;


/*
*
* 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gas-station
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
*
* */
public class GasStation {
    public static void main(String[] args) {
        int[] stationGas = {1,2,3,4,5};
        int[] stationCostGas = {3,4,5,1,2};
        int startStation = computeStartStation(stationGas,stationCostGas);
        System.out.println(startStation);
    }

    private static int computeStartStation(int[] stationGas, int[] stationCostGas) {
        if(stationGas.length ==0 ) {
            throw new IllegalArgumentException("加油站长度不额能0");
        }
        if(stationGas.length != stationCostGas.length) {
            throw new IllegalArgumentException("具有油量的加油站长度和消耗油量的加油站长度必须相同");
        }

        int startStation = -1;


        for(int chooseStation=0;chooseStation<stationGas.length;chooseStation++) {
            int currentGas = 0;
            for(int currentStation=chooseStation;currentStation < stationGas.length;currentStation++) {
                int nextStation = currentStation+1;
                if(nextStation == stationGas.length) {
                    nextStation = 0;
                }
                currentGas+=stationGas[currentStation];
                int costGas = stationCostGas[currentStation];
                int afterGas = currentGas - costGas;
                if(afterGas<0) {
                    break;
                }
                if(afterGas>=0) {
                    if(nextStation==chooseStation) {
                        return chooseStation;
                    }
                }
                currentGas = afterGas;
                if(nextStation == 0) {
                    currentStation = -1;
                }
            }
        }

        return startStation;
    }
}
