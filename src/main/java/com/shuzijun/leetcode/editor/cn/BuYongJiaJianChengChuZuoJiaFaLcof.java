//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 209 👎 0


package com.shuzijun.leetcode.editor.cn;

public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
        System.out.println(solution.add(6, 19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                int sum = a ^ b;
                int carry = (a & b) << 1;
                a = sum;
                b = carry;
                System.out.println("sum:" + sum + ",carry:" + carry);
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
