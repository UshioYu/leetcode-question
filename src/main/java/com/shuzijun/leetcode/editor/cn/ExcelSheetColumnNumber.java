//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。 
//
// 
//
// 例如， 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 示例 4: 
//
// 
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 👍 294 👎 0

package com.shuzijun.leetcode.editor.cn;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();
        System.out.println(solution.titleToNumber("BA"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // Z-26(1*26) AA-27(1*26+1*1) AB-28(1*26+2*1) BA(2*26+1*1)
        public int titleToNumber(String columnTitle) {
            int number = 0;
            int multiple = 1;//即26的0次方
            for (int i = columnTitle.length() - 1; i >= 0; i--) {
                int k = columnTitle.charAt(i) - 'A' + 1;
                System.out.println("k:" + k);
                number += k * multiple;
                multiple *= 26;
            }
            return number;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
