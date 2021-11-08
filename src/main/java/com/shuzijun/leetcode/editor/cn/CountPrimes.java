//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 774 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 埃氏筛
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            int[] isPrime = new int[n];
            //初始化给isPrime数组赋值均为1，表示默认认为所有都是质数
            Arrays.fill(isPrime, 1);
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i] == 1) {
                    count++;
                    //把当前质数的倍数全部标记为合数
                    //2i,3i,… 这些数一定在i之前就被其他数的倍数标记过了
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = 0;
                        }
                    }
                }
            }
            return count;
        }

//        //枚举法
//        public int countPrimes(int n) {
//            int count = 0;
//            for (int i = 2; i < n; i++) {
//                count += isPrime(i) ? 1 : 0;
//            }
//            return count;
//        }

        /**
         * 判断是否为质数，后面用枚举法完成
         * @param n
         * @return
         */
        public boolean isPrime(int n){
            //只需要判断2到根号i之间（因为y和i/y中的一个必落在根号i左侧）
            for (int i = 2; (long)i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
   //leetcode submit region end(Prohibit modification and deletion)

}
