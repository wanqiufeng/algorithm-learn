package com.vincent.algorithm.basic.array;

/**
 * Created by chenjun on 19-6-1.
 */
public class Rotate {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] a = new int[]{1,2,3,4,5,6,7};
        solution.rotate(a,3);
        for(int i:a) {
            System.out.println(i);
        }
    }
    static class Solution {
        public void rotate(int[] nums, int k) {
            int cache=0;//用于覆盖下一个数组元素的值
            int cache1;//用于缓存下一个数组元素的临时值

            //外层循环，用于控制移位的次数
            for(int r=0;r<k;r++) {

                //内层循环，用于控制每次移位时，两两覆盖（左边的覆盖右边紧邻的数值）
                for(int i=0;i<nums.length;i++) {
                    if(i == 0) {
                        //如果第一次循环，用于覆盖下一个元素的值就为第一个元素的值
                        cache = nums[i];
                    }
                    if(i<nums.length-1) {
                        //如果还没有循环到数组最后一个元素时

                        cache1 = nums[i+1];//用cache1缓存下一个数组元素
                        nums[i+1] = cache;//用缓存中的前一个元素覆盖下一个元素
                        cache = cache1;//将下一个元素原本的值，放到缓存中，方便其下次移动覆盖到它的下一位
                    } else {
                        //如果是数组最后的元素，那么直接将缓存中的值，覆盖到第一位元素
                        nums[0] = cache;
                    }
                }
            }
        }


        public void rotate1(int[] nums, int k){
            //多米洛骨牌思想。从第一个元素开始，计算其需移动或者覆盖的目的地。
            //同时缓存目的地元素，并将第一个元素覆盖到目的地中。
            //被覆盖的目的地元素，有计算自己的目的地，并向上述的逻辑那样，进行操作
            //目的地的计算，通过自己当前的位置，加上要移动的k位，同数组的长度取模，这样能保证越界数组后的循环
            //如果多米洛骨牌轮回循环到最初始的元素位置，说明整个连锁反应结束。停止程序
            //该算法的好处是，减少每个元素的移动次数，每个元素一次性的移动到位，而不是step by step的移动

            if(k==nums.length || k==0 || nums.length<=1) {
                //说明每个元素都要移动数组长度个位置，相当于一个轮回，结果还是跟以前一样，那就干脆不移动
                //如果移动位数为０，也说明不移动
                //如果数组本身长度小于等于１，那也不需要移动
                return;
            }
            for(int loopIndex=0;loopIndex<k;loopIndex++) {
                int i = loopIndex;
                int cache = nums[i];
                int replacedCached;
                do{
                    int replaceIndex = (i+k)%nums.length;
                    replacedCached=nums[replaceIndex];
                    nums[replaceIndex] = cache;
                    cache = replacedCached;
                    i = replaceIndex;
                } while (i!=loopIndex);
            }
        }
    }
}

