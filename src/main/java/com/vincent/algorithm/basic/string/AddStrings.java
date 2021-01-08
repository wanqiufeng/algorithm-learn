package com.vincent.algorithm.basic.string;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和。
 *
 * 
 *
 * 提示：
 *
 * num1 和num2的长度都小于 5100
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {
    public static void main(String[] args) {

    }

    /**
        结题思路：
        1.采用双指针，分别指向两个数字字符串的低位，低位在字符串的最大字符处，也即length-1
        2.通过char-'0' ,可以得到对应的int value
        3.分别取两个数字对应的位相加，并将进位add保留给下次使用
        4.每一步的结果收集到StringBuilder中，由于是按个位数收集，要返回结果字符串，需要将StringBuilder reverse下

        总结：使用双指针

        需要注意的点，即便两个指针都指向了0。也还需要判断一下进位的数字是否是1，如果是1的话还需要走遍逻辑。比如遇到9+1这种情况，会出现位数扩充

     * @return
     */
    public String addStrings(String num1, String num2) {
        if(num1 == null) return num2;
        if(num2 == null) return num1;

        StringBuilder stringBuffer = new StringBuilder();
        int i = num1.length()-1;
        int j= num2.length()-1;
        int add=0;
        while (i>=0||j>=0||add != 0) {
            //注意，如果进位不为0，还需要做下面的逻辑。
            int numberOne = i>=0? num1.charAt(i)-'0':0;
            int numberTwo = j>=0? num2.charAt(j)-'0':0;
            int sum = numberOne+numberTwo+add;
            stringBuffer.append(sum%10);
            add = sum/10;
            i--;
            j--;
        }
        StringBuilder reverse = stringBuffer.reverse();
        return reverse.toString();
    }
}
