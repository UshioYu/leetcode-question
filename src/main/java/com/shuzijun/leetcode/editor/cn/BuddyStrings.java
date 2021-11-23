//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 10⁴ 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 👍 209 👎 0

package com.shuzijun.leetcode.editor.cn;

public class BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean buddyStrings(String s, String goal) {
            int sLen = s.length();
            int gLen = goal.length();
            if (sLen != gLen) return false;
            if (s.equals(goal)) {
                //两个字符串相等的时候，此时当字符串内部包含2个字符相同即可满足条件，因为你交换这两个字符即可
                int[] counts = new int[26];
                for (int i = 0; i < sLen; i++) {
                    counts[s.charAt(i) - 'a']++;
                    if (counts[s.charAt(i) - 'a'] >= 2) {
                        return true;
                    }
                }
                return false;
            } else {
                int first = -1, second = -1;
                for (int i = 0; i < gLen; i++) {
                    if (s.charAt(i) != goal.charAt(i)) {
                        if (first == -1) {
                            //优先给first赋值
                            first = i;
                        } else if (second == -1) {
                            //第二次给second赋值
                            second = i;
                        } else {
                            //有第三个元素不等，这里交换后肯定也不成立，直接false
                            return false;
                        }
                    }
                }
                //不可能出现first为-1的情景，因为他俩不等，second为-1表示只匹配到一个元素不等
                return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
