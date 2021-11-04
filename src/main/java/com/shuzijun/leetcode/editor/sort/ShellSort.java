package com.shuzijun.leetcode.editor.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        ShellSort.Solution solution = new ShellSort().new Solution();
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        solution.shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    class Solution {
        public void shellSort(int[] array) {
            if (array == null || array.length <= 1) {
                return;
            }
            int insertNum, gap = array.length / 2;
            while (gap > 0) {
                for (int i = gap; i < array.length; i++) {
                    //给插入的数据赋值
                    insertNum = array[i];
                    //已经排好序的元素个数
                    int j = i - gap;
                    while (j >= 0 && array[j] > insertNum) {
                        //从后到前循环，将大于insertNum的数向后移动一格
                        array[j + gap] = array[j];
                        j = j - gap;
                    }
                    //将需要插入的数放在要插入的位置
                    array[j + gap] = insertNum;
                }
                gap = gap / 2;
            }

        }
    }
}
