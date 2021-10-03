//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 257 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String result = "";
            Collections.sort(dictionary, (o1, o2) -> {
                if (o1.length() != o2.length()) {
                    //长的放前面
                    return o2.length() - o1.length();
                } else {
                    //小的字符在前面
                    return o1.compareTo(o2);
                }
            });
            for (String t : dictionary) {
                int i = 0, j = 0;
                while (i < t.length() && j < s.length()) {
                    if (t.charAt(i) == s.charAt(j)) {
                        i++;
                    }
                    j++;
                }
                //表示t是s的子序列
                if (i == t.length())
                    //下面这个if判断也可不用，改成在开始对dictionary先进行排序
//                    if (t.length() > result.length() ||
//                            (t.length() == result.length() && t.compareTo(result) < 0)) {
//                        result = t;
                return t;
//                    }
                }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
