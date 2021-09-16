//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2027 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        int[] nums = new int[]{1,2,3,2,4,1,5,4,5};
        System.out.println(solution.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
//            int a = 0;
//            for (int num : nums) {
//                a ^= num;
//            }
//            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
