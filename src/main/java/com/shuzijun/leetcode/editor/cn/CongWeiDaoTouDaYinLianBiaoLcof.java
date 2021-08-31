//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 179 👎 0


package com.shuzijun.leetcode.editor.cn;

import com.shuzijun.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode q = head;
            int size = 0;
            while (q != null) {
                size++;
                q = q.next;
            }
            q = head;
            int[] print = new int[size];
            for (int i = size-1; i > 0; i--) {
                print[i] = q.val;
                q = q.next;
            }
            return print;
//            Stack<Integer> stack = new Stack<>();
//            while (q != null) {
//                stack.push(q.val);
//                q = q.next;
//            }
//            int size = stack.size();
//            int[] print = new int[size];
//            for (int i = 0; i < size; i++) {
//                print[i] = stack.pop();
//            }
//            return print;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
