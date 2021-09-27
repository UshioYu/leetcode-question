//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心 哈希表 双指针 字符串 👍 571 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            int size = s.length();
            //for循环计算s中的字母出现的最后一个位置
            for (int i = 0; i < size; i++) {
                last[s.charAt(i) - 'a'] = i;
            }
            //记录分割的位置，存入list
            List<Integer> parition = new ArrayList<>();
            //记录初始位置和结束位置
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                //遍历取出end的最大值(当前i位置对应的字母在string里的最大位置)
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    //表示可以截取了
                    parition.add(end - start + 1);
                    start = end + 1;
                }
            }
            return parition;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
