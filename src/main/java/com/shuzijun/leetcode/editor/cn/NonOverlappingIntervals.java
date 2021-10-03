//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心 数组 动态规划 排序 👍 504 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;
            if (n ==0)
                return 0;
            //给区间按照右边的元素顺序排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            //需要的区间（第一个区间是一定要的，所以初始为1）
            int count = 1;
            //定义右边的元素
            int right = intervals[0][1];
            for (int i = 0; i < n; i++) {
                //当遍历的左元素比之前的右元素大或相等（相等也要考虑进去），表示是需要的区间，count加1记录
                if (intervals[i][0] >= right) {
                    ++count;
                    //给右元素继续赋值
                    right = intervals[i][1];
                }
            }
            return n - count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
