//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 数组 👍 721 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
        int[] nums = new int[]{1, 2, 3, 2, 2, 3, 1, 4, 1, 3};
        System.out.println(solution.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num, 0) + 1);
            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                int num = integerIntegerEntry.getValue();
                int key = integerIntegerEntry.getKey();
                if (num == 1) {
                    ans = key;
                    break;
                }
            }
            return ans;
        }

        public int FirstNotRepeatingChar(String str) {
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }
            int pos = -1;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (map.get(c) == 1) {
                    pos = i;
                    break;
                }
            }
            return pos;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
