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

        int[] tmp;

        public int[] sortArray(int[] array) {
            tmp = new int[array.length];
            if (array == null || array.length <= 1) {
                return array;
            }
            mergeSort(array, 0, array.length - 1);
            return array;
        }

        public void mergeSort(int[] array, int left, int right) {
            if (left >= right) {
                return;
            }
            int middle = (left + right) >> 1;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            int i = left, j = middle + 1;
            int cnt = 0;
            while (i <= middle && j <= right) {
                if (array[i] <= array[j]) {
                    tmp[cnt++] = array[i++];
                } else {
                    tmp[cnt++] = array[j++];
                }
            }
            while (i <= middle) {
                tmp[cnt++] = array[i++];
            }
            while (j <= right) {
                tmp[cnt++] = array[j++];
            }
            for (int k = 0; k < right - left + 1; k++) {
                array[left + k] = tmp[k];
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
