//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？ 
// Related Topics 数组 二分查找 👍 272 👎 0


package com.shuzijun.leetcode.editor.cn;

class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            //暴力美学法
//            for (int i = 0; i < nums.length; i += 2) {
//                if (nums[i] != nums[i + 1]) {
//                    return nums[i];
//                }
//            }
//            return nums[nums.length - 1];

//            int low = 0;
//            int high = nums.length - 1;
//            while (low < high) {
//                int middle = (low + high) / 2;
//                boolean halvesAreEven = (middle - low) % 2 == 0;
//                if (nums[middle] == nums[middle + 1]) {
//                    //中间元素的同一元素在右边
//                    if (halvesAreEven) {
//                        //被 mid 分成两半的数组为偶数,比如1144 5 5688
//                        low = middle + 2;
//                    } else {
//                        //被 mid 分成两半的数组为奇数,比如11455 6 68899
//                        high = middle - 1;
//                    }
//                } else if (nums[middle] == nums[middle - 1]) {
//                    //中间元素的同一元素在左边
//                    if (halvesAreEven) {
//                        //被 mid 分成两半的数组为偶数,比如1145 5 6688
//                        high = middle - 2;
//                    } else {
//                        //被 mid 分成两半的数组为奇数,比如114 4 5688
//                        low = middle + 1;
//                    }
//                } else {
//                    return nums[middle];
//                }
//            }
//            return nums[low];
            //仅对偶数索引进行二分搜索
            //对所有偶数索引进行搜索，直到遇到第一个其后元素不相同的索引
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int middle = (low + high) / 2;
                if (middle % 2 == 1) middle--;//--是怕漏掉漏网之鱼
                if (nums[middle] == nums[middle + 1]) {
                    low = middle + 2;
                } else {
                    high = middle;
                }
            }
            return nums[low];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
