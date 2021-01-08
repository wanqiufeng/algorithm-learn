package com.vincent.algorithm.basic.array;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKHeapSortWithPriorityQueue {
        public List<Integer> topk_max(List<Integer> unsortList,int kNumber) {
            if(kNumber < 0 ) {
                throw new IllegalArgumentException("kNumber must be a positive integer");
            }
            if(kNumber ==0 ||unsortList== null ||unsortList.size() == 0) {
                return new ArrayList<>();
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(unsortList);
            while (queue.size() != kNumber) {
                queue.poll();
            }
            return queue.stream().collect(Collectors.toList());
        }


    public List<Integer> topk_min(List<Integer> unsortList,int kNumber) {
        if(kNumber < 0 ) {
            throw new IllegalArgumentException("kNumber must be a positive integer");
        }
        if(kNumber ==0 ||unsortList== null ||unsortList.size() == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(kNumber, Comparator.reverseOrder());
        for(Integer i :unsortList) {
            queue.add(i);
            if(queue.size()>kNumber) {
                queue.poll();
            }
        }
        return queue.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //准备未排序的list
        //肉眼可观测的topk
        //调用方法，从中获取topk
        //跟肉眼可观测的topk比较

        List<Integer> unsortList = Lists.newArrayList( 7, 8,1, 3, 5, 6, 9);
        TopKHeapSortWithPriorityQueue topKHeapSortWithPriorityQueue = new TopKHeapSortWithPriorityQueue();
        List<Integer> topk_max = topKHeapSortWithPriorityQueue.topk_max(unsortList,1);
        List<Integer> topk_min = topKHeapSortWithPriorityQueue.topk_min(unsortList,1);
        topk_max.stream().forEach(integer -> System.out.println(integer));
        topk_min.stream().forEach(integer -> System.out.println(integer));
    }
}
