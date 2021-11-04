package com.shuzijun.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort.Solution solution = new InsertionSort().new Solution();
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        solution.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    class Solution {
        public void insertionSort(int[] array) {
            if (array == null || array.length <= 1) {
                return;
            }
            int insertNum;
            for (int i = 1; i < array.length; i++) {
                //给插入的数据赋值
                insertNum = array[i];
                //已经排好序的元素个数
                int j = i - 1;
                while (j >= 0 && array[j] > insertNum) {
                    //从后到前循环，将大于insertNum的数向后移动一格
                    array[j + 1] = array[j];
                    j--;
                }
                //将需要插入的数放在要插入的位置
                array[j + 1] = insertNum;
            }
        }
    }
}
