package com.shuzijun.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort.Solution solution = new SelectionSort().new Solution();
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        solution.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    class Solution {
        public void selectionSort(int[] array) {
            if(array == null || array.length<=1){
                return;
            }
            int minIndex, tmp;
            for (int i = 0; i < array.length - 1; i++) {
                //定义最小的index
                minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if(array[j]<array[minIndex]){
                        minIndex = j;
                    }
                }
                //交换minIndex和i的位置
                if (minIndex != i) {
                    tmp = array[minIndex];
                    array[minIndex] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }
}
