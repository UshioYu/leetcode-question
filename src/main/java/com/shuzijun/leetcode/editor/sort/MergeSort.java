package com.shuzijun.leetcode.editor.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort.Solution solution = new MergeSort().new Solution();
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    class Solution {
        //Description: 归并排序
        public void mergeSort(int[] array) {
            if (array == null || array.length <= 1) {
                return;
            }
            sort(array, 0, array.length - 1);
        }

        public void sort(int[] array, int left, int right) {
            if (left == right) {
                return;
            }
            System.out.println("0-----" + Arrays.toString(array));
            int mid = left + ((right - left) >> 1);
            System.out.println(mid);
            // 对左侧子序列进行递归排序
            sort(array, left, mid);
            System.out.println("1-----" + Arrays.toString(array));
            // 对右侧子序列进行递归排序
            sort(array, mid + 1, right);
            System.out.println("2-----" + Arrays.toString(array));
            // 合并
            merge(array, left, mid, right);
            System.out.println("3-----" + Arrays.toString(array));
        }

        public void merge(int[] array, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = 0;
            int p1 = left;
            int p2 = mid + 1;
            // 比较左右两部分的元素，哪个小，把那个元素填入temp中
            while (p1 <= mid && p2 <= right) {
                temp[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
            }
            // 上面的循环退出后，把剩余的元素依次填入到temp中
            // 以下两个while只有一个会执行
            while (p1 <= mid) {
                temp[i++] = array[p1++];
            }
            while (p2 <= right) {
                temp[i++] = array[p2++];
            }
            // 把最终的排序的结果复制给原数组
            for (i = 0; i < temp.length; i++) {
                array[left + i] = temp[i];
            }
        }
    }
}
