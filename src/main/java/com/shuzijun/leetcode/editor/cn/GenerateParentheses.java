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
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 1) {
                return Arrays.asList("()");
            }
            HashSet<String> set = new HashSet<>();
            for (String str : generateParenthesis(n - 1)) {
                System.out.println("str:" + str);
                for (int i = 0; i <= str.length() / 2; i++) {
                    System.out.println(str.substring(0, i));
                    System.out.println(str.substring(i));
                    String s = str.substring(0, i) + "()" + str.substring(i);
                    System.out.println("s:"+s);
                    set.add(s);
                }
            }
            return new ArrayList<>(set);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
