//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 897 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            //遍历整个数组，并使用哈希表记录每个数字出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            //新建一个小顶堆
            //int[] 第一个元素表示数组元素的值，第二个元素表示数组元素出现的次数
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            //遍历map
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int value = entry.getKey();
                int count = entry.getValue();
                if (queue.size() == k) {
                    if (queue.peek()[1] < count) {
                        //堆顶比当前出现次数小，弹出堆顶，再插入
                        queue.poll();
                        queue.offer(new int[]{value, count});
                    } else {
                        //堆顶大，说明至少有k个数字的出现次数比当前值大，故舍弃当前值
                    }
                } else {
                    //堆的元素个数小于K，直接插进来
                    queue.offer(new int[]{value, count});
                }
            }
            //把堆的值转成数组
            int[] ret = new int[k];
            for (int i = 0; i < k; i++) {
                ret[i] = queue.poll()[0];
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
