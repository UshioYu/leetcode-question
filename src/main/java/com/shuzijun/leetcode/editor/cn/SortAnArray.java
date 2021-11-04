//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 413 👎 0

package com.shuzijun.leetcode.editor.cn;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] array) {
            if (array == null || array.length <= 1) {
                return array;
            }
            sort(array, 0, array.length - 1);
            return array;
        }

        public void sort(int[] array, int left, int right) {
            if (array == null || left >= right || array.length < 1) {
                return;
            }
            int middle = partition(array, left, right);
            sort(array, left, middle);
            sort(array, middle + 1, right);
        }

        public int partition(int[] array, int left, int right) {
            int temp = array[left];
            while (left < right) {
                while (left < right && temp <= array[right]) {
                    right--;
                }
                if (left < right) {
                    array[left++] = array[right];
                }
                while (left < right && temp >= array[left]) {
                    left++;
                }
                if (left < right) {
                    array[right--] = array[left];
                }
            }
            array[left] = temp;
            return left;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
