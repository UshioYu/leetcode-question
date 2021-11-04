//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1358 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            quickSort(nums, k);
            return nums[nums.length - k];
        }

        public void quickSort(int[] array, int k) {
            if (array == null || array.length <= 1) {
                return;
            }
            sort(array, 0, array.length - 1, k);
        }

        public void sort(int[] array, int left, int right, int k) {
            if (array == null || left >= right || array.length < 1) {
                return;
            }
            int middle = partition(array, left, right);
            if (middle == array.length - k) {
                return;
            }
            sort(array, left, middle,k);
            sort(array, middle + 1, right,k);
        }

        public int partition(int[] array, int left, int right) {
            // 随机选一个作为我们的主元(然后先交互i和left的值，当然也可以直接选用left的值来作为随机数)
            int i = new Random().nextInt(right - left + 1) + left;
            int temp = array[i];
            if (i != left) {
                array[i] = array[left];
                array[left] = temp;
            }
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
