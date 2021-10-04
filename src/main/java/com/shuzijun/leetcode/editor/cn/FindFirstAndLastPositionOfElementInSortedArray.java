//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1238 👎 0


package com.shuzijun.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //数组中寻找第一个大于等于target 的下标
            int leftIndex = binarySearch(nums, target, true);
            //在数组中寻找第一个大于target 的下标，然后将下标减一
            int rightIndex = binarySearch(nums, target, false) - 1;
            if (leftIndex <= rightIndex && rightIndex < nums.length
                    && nums[leftIndex] == target && nums[rightIndex] == target) {
                return new int[]{leftIndex, rightIndex};
            }
            return new int[]{-1, -1};
        }

        public int binarySearch(int[] nums, int target,boolean isEquals) {
            int left = 0, right = nums.length - 1, position = nums.length;
            while(left<=right){
                int mid = (left + right) / 2;
                if (nums[mid] > target || (isEquals && nums[mid] == target)) {
                    right = mid - 1;
                    position = mid;
                } else {
                    left = mid + 1;
                }
            }
            return position;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
