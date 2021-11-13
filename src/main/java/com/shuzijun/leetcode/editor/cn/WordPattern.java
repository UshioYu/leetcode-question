//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 字符串 👍 398 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            Map<Character,String> char2Str = new HashMap<>();
            Map<String,Character> str2char = new HashMap<>();
            int sLength = s.length();
            int i = 0;//定义一个变量，后续用于截取s
            for (int j = 0; j < pattern.length(); j++) {
                if (i >= sLength) {
                    //为什么是false呢，因为pattern还未匹配完
                    // 此时s字符串已经到结尾，表示只是s中是有多余元素的，所以是false
                    //典型的用例pattern=s="jquery"
                    return false;
                }
                int p = i;
                while (p < sLength && s.charAt(p) != ' ') {
                    p++;
                }
                //计算出i和p，确定本次截取的字符串的子串
                String tmp = s.substring(i,p);
                char ch = pattern.charAt(j);
                if (char2Str.containsKey(ch) && !char2Str.get(ch).equals(tmp)) {
                    return false;
                }
                if (str2char.containsKey(tmp) && str2char.get(tmp) != ch) {
                    return false;
                }
                char2Str.put(ch,tmp);
                str2char.put(tmp,ch);
                i = p + 1;
            }
            //这里为什么是i >= sLength为true呢，因为pattern已经匹配完
            return i >= sLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
