//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1027 👎 0


package com.shuzijun.leetcode.editor.cn;

import com.shuzijun.leetcode.ListNode;
import com.sun.istack.internal.NotNull;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;l2.next = l3;l3.next = l4;l4.next = l5;
        System.out.println(l1);
        System.out.println(solution.reverse(l1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            return head;
        }

        public ListNode reverse(ListNode head) {
            // 判断链表为空或长度为1的情况
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null; // 当前节点的前一个节点
            ListNode next; // 当前节点的下一个节点
            while( head != null){
                System.out.println("cur head:" + head);
                next = head.next; // 记录当前节点的下一个节点位置；
                head.next = pre; // 让当前节点指向前一个节点位置，完成反转
                System.out.println("head.next:" + head.next);
                System.out.println("cur head1:" + head);
                pre = head; // pre 往右走
                head = next;// 当前节点往右继续走
                System.out.println("pre:" + pre);
                System.out.println("head:" + head);
                System.out.println("--------------");
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
