package com.vincent.algorithm.basic.stack;

import java.util.LinkedList;

/**
 * 给定pushed和popped两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * 
 *
 * 提示：
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed是popped的排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateStackSequences {
    public static void main(String[] args) {

    }


    /**
     视频讲解：https://www.youtube.com/watch?v=wKrcOVj0Ahg&t=55s

     直接把入栈和弹栈的逻辑用代码实现，去复刻整个过程，如果最后栈的结果是空，说明复刻成功。

     1. 我们在对栈进行操作过程中，有入栈有出栈，
     2.pushed 是我们入栈的顺序，当然这个过程中有出栈，其顺序依赖popped
     3.popped 是我们出栈的顺序，如果用指针从0开始迭代它的话，每一个位置，都是当时栈顶的位置
     4.所以，基本解题思路，我们要使用一个栈去模拟入栈过程。所以外层要有一个for循环，对数据进行入栈
     5.循环我们基于popped 当前的位置，去看栈顶元素是不是就是当前栈的栈顶，如果是，那就出栈。
     6.由于一个元素入栈后，可能不只有一个元素出栈，所以，我们判断出栈的代码也是一个循环
     7.最后如果我们的栈为空，说明进过上述过程已经把数据清理完全，这个栈操作没问题。


     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList();
        int popPinter=0;
        for(int pushValue:pushed) {
            stack.push(pushValue);
            while (!stack.isEmpty() && popped[popPinter] == stack.peek()) {
                stack.pop();
                popPinter++;
            }
        }
        return stack.isEmpty();
    }
}
