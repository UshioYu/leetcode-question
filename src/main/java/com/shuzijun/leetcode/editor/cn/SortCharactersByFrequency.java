//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 346 👎 0

package com.shuzijun.leetcode.editor.cn;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String frequencySort(String s) {
            //先把字符和具体出现次数存入map，同时记录最高频率maxFreq
            int maxFreq = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int freq = map.getOrDefault(c, 0) + 1;
                map.put(c, freq);
                maxFreq = Math.max(maxFreq, freq);
            }
            //创建桶，存储从1到maxFreq每个出现频率的字符
            StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
            for (int i = 0; i <= maxFreq; i++) {
                buckets[i] = new StringBuffer();
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char c = entry.getKey();
                int freq = entry.getValue();
                buckets[freq].append(c);
            }
            //拼接,从桶里取数据
            StringBuffer sb = new StringBuffer();
            for (int i = maxFreq; i > 0; i--) {
                StringBuffer bucket = buckets[i];
                for (int j = 0; j < bucket.length(); j++) {
                    for (int k = 0; k < i; k++) {
                        sb.append(bucket.charAt(j));
                    }
                }
            }
            return sb.toString();
        }

        public String frequencySort1(String s) {
            //先把字符和具体出现次数存入map
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            //map转list然后进行sort排序
            List<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
            //字符串拼接
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                char c = list.get(i);
                int count = map.get(c);
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
