package com.vincent.algorithm.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 
 *
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 *
 * 
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * 
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCacheImpl lRUCache = new LRUCacheImpl(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4


    }


    /**
     *
     思路：
        取巧的方式，可以使用java自带的LinkedHashMap ,但那样实现会太简单了。
        所以创建一个双端链表自己来实现。类中还必须记录下双端链表的头和尾，初始化时，头指向尾，尾指向头。
        头指针，是方便新访问和新插入的数据，能够快速头插。
        尾指针，方便淘汰数据时，能够快速的基于淘汰末尾的数据

        那如何能够快速索引到原始在链表中的位置？
            方法1.当然可以笨办法，循环去查找
            方法2。本例使用hashmap来存储，某个值对应的链表数据，从而实现快速索引

     *
     */
    public static class LRUCacheImpl {
        Map<Integer,DoubleLinkNode> nodeIndex = new HashMap<>();
        private int size = 0;
        private int capacity=0;
        DoubleLinkNode head;
        DoubleLinkNode tail;
        public class DoubleLinkNode {
            int key;
            int value;
            DoubleLinkNode pre;
            DoubleLinkNode next;
        }

        public LRUCacheImpl(int capacity) {
            this.capacity = capacity;
            head = new DoubleLinkNode();
            tail = new DoubleLinkNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DoubleLinkNode doubleLinkNode = nodeIndex.get(key);
            if(doubleLinkNode!= null) {
                moveToHead(doubleLinkNode);
                return doubleLinkNode.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            //如果不存在，
                //直接创建一个新的插入
                //如果超限，则删除尾部元素
                //size加1

            //如果存在，则更新值，并移动
            DoubleLinkNode doubleLinkNode = nodeIndex.get(key);
            if(doubleLinkNode == null) {
                size++;
                if(size>capacity) {
                    removeTail();
                    size--;
                }
                insertToHead(key,value);
            } else {
                doubleLinkNode.value = value;
                moveToHead(doubleLinkNode);
            }
        }

        private void insertToHead(int key, int value) {
            DoubleLinkNode doubleLinkNode = new DoubleLinkNode();
            doubleLinkNode.key = key;
            doubleLinkNode.value = value;
            DoubleLinkNode temp = head.next;
            head.next=doubleLinkNode;
            doubleLinkNode.pre = head;
            doubleLinkNode.next = temp;
            temp.pre = doubleLinkNode;
            nodeIndex.put(key,doubleLinkNode);
        }

        private void removeTail() {
            DoubleLinkNode waitRemoveNode = tail.pre;
            deleteNode(waitRemoveNode);
            nodeIndex.remove(waitRemoveNode.key);
        }


        private void deleteNode(DoubleLinkNode node){
            DoubleLinkNode next = node.next;
            DoubleLinkNode pre = node.pre;
            pre.next = next;
            next.pre = pre;
        }

        private void moveToHead(DoubleLinkNode doubleLinkNode) {
            deleteNode(doubleLinkNode);
            insertToHead(doubleLinkNode.key,doubleLinkNode.value);
        }


    }
}
