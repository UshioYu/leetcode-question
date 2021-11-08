//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 102 👎 0

package com.shuzijun.leetcode.editor.cn;

public class Base7 {
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) return "0";
            StringBuffer sb = new StringBuffer();
            int x = num < 0 ? -num : num;
            while (x > 0) {
                int y = x % 7;
                //插在前面
                sb.insert(0, y);
                x = x / 7;
            }
            if (num < 0) sb.insert(0, "-");
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
