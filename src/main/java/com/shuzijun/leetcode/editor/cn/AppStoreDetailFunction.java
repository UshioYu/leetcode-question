//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2037 👎 0


package com.shuzijun.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class AppStoreDetailFunction {
    public static void main(String[] args) {
        Solution solution = new AppStoreDetailFunction().new Solution();
        //String[] strings = new String[]{"1","2","1","3","2","1","4","5","1","6","7","1","1","8"};
        //String[] strings = new String[]{"1","2","1","1","8"};
        //String[] strings = new String[]{"1","8"};
        String[] strings = new String[]{"1"};
        List<String> list2 = new ArrayList<String>(strings.length);
        Collections.addAll(list2, strings);
        System.out.println(solution.function(list2,5,"1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param strList 源list
         * @param count 需要获取的数据长度
         * @param m 匹配的数据
         * @return
         */
        public List<String> function(List<String> strList,int count, String m) {
            if (strList == null || strList.size() == 0) {
                return null;
            }
            List<String> resultList = new ArrayList<>();
            int totalSize = strList.size();
            for (int i = 0; i < totalSize; i++) {
                int random = (int) (Math.random() * strList.size());
                String curValue = strList.get(random);
                strList.remove(random);
                if (m.equals(curValue)) {
                    continue;
                }
                resultList.add(curValue);
                if (resultList.size() >= count) {
                    break;
                }
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
