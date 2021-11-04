package com.shuzijun.leetcode.editor.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort.Solution solution = new QuickSort().new Solution();
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        solution.quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    class Solution {
        public void quickSort(int[] array) {
            if (array == null || array.length <= 1) {
                return;
            }
            sort(array, 0, array.length - 1);
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
}
