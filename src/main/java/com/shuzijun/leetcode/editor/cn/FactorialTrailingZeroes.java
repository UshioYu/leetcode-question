//给定一个整数 n ，返回 n! 结果中尾随零的数量。 
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
// 
//
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁴ 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
// Related Topics 数学 👍 513 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.math.BigInteger;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 最简洁
         * @param n
         * @return
         */
        public int trailingZeroes(int n) {
            return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
        }

        /**
         * 计算因子5，就是不够简洁
         * @param n
         * @return
         */
//        public int trailingZeroes(int n) {
//            int count = 0;
//            for (int i = 5; i <= n; i += 5) {
//                int tmp = i;
//                while (tmp % 5 == 0) {
//                    count++;
//                    tmp /= 5;
//                }
//            }
//            return count;
//        }

        /**
         * 暴力，就是慢
         * @param n
         * @return
         */
//        public int trailingZeroes(int n) {
//            BigInteger bi = BigInteger.ONE;
//            //calculate n!计算n阶乘
//            for (int i = 2; i <= n; i++) {
//                bi = bi.multiply(BigInteger.valueOf(i));
//            }
//            //count how many 0 are on the end
//            int count = 0;
//            while (bi.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
//                bi = bi.divide(BigInteger.TEN);
//                count++;
//            }
//            return count;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
