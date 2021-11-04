package com.shuzijun.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort.Solution solution = new BubbleSort().new Solution();
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        solution.bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    class Solution {
        public void bubbleSort(int[] array) {
            if (array == null || array.length <= 1) {
                return;
            }
            int tmp;
            for (int i = 0; i < array.length; i++) {
                //i从0开始最大为array.length-1,而j从0开始（j是主比较项，
                // 比较array[j]和array[j+1]），
                //最大到array.length-1-i(i最小为0时，j最大) -1是怕数组越界
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        tmp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = tmp;
                    }
                }
            }
        }
    }
}
