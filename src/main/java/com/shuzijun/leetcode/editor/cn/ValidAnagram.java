//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 👍 447 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length()!=t.length()){
                return false;
            }
            //方法1 排序后直接进行equals比较
//            char[] sArray = s.toCharArray();
//            char[] tArray = t.toCharArray();
//            Arrays.sort(sArray);
//            Arrays.sort(tArray);
//            return Arrays.equals(sArray,tArray);
            //方法2 维护一个26位的int数组。遍历s，把出现的字符添加到数组里
//            int[] intArray = new int[26];
//            for (int i = 0; i < s.length(); i++) {
//                intArray[s.charAt(i) - 'a']++;
//            }
//            for (int i = 0; i < t.length(); i++) {
//                intArray[t.charAt(i) - 'a']--;
//                if (intArray[t.charAt(i) - 'a'] < 0) {
//                    //表示t中有多余的字符。在s中不存在
//                    return false;
//                }
//            }
//            return true;
            //方法3 维护一个hashmap表
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
