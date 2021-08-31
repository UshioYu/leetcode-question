//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6027 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //滑动窗口思想解决此问题
            Set<Character> set = new HashSet<>();
            int n = s.length();
            //右指针,-1表示在字符串左侧边界，还未移动
            int rk = -1;
            //计算最大的子串个数变量
            int maxLength = 0;
            for (int i = 0; i < n; i++) {
                //遍历整个string，第一次无需移除第一个元素，第二次开始每次移除一个元素
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                //while开启右指针右移操作
                while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                    set.add(s.charAt(rk + 1));
                    rk++;
                }
                //计算出当前的最大值，进行比较替换
                maxLength = Math.max(maxLength, rk - i + 1);
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
