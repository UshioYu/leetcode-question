//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 161 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.TreeSet;

public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        int[] nums = new int[]{0,0,3,5,9};
        System.out.println(solution.isStraight(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            //简单来说就是要是5个数字，最大和最小差值在5以内，并且没有重复数值。
            // 用一个set来填充数据，0不要放进去。set的大小加上0的个数必须为5个。此外set中数值差值在5以内
            if (nums == null || nums.length != 5)
                return false;
            TreeSet<Integer> integerSet = new TreeSet<>();
            int sum = 0;
            for (int num : nums) {
                if (num != 0)
                    integerSet.add(num);
                else
                    sum++;
            }
            if (sum + integerSet.size() != 5)
                //加这个判断是因为可能有重复数字
                return false;

            if (integerSet.last() - integerSet.first() < 5)
                return true;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
