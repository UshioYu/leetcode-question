//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，
//pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 哈希表 链表 双指针 👍 1204 👎 0


package com.shuzijun.leetcode.editor.cn;

import com.shuzijun.leetcode.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        /**
         * 用快慢指针解决
         * 给定两个指针，
         * 分别命名为 slow 和 fast，起始位置在链表的开头。每次 fast 前进两步，slow 前进一步。如果 fast
         * 可以走到尽头，那么说明没有环路；如果 fast 可以无限走下去，那么说明一定有环路，且一定存
         * 在一个时刻 slow 和 fast 相遇。当 slow 和 fast 第一次相遇时，我们将 fast 重新移动到链表开头，并
         * 让 slow 和 fast 每次都前进一步。当 slow 和 fast 第二次相遇时，相遇的节点即为环路的开始点
         * 这里的思想：
         * 之所以慢指针跑一圈的过程中，快指针一定能追上是因为：（极限思想） 假设他们都是从入环点开始跑的，那么当慢指针刚好跑完一圈时，快指针刚好跑完两圈，也是在一圈的末尾追上慢指针。而现实情况往往是在慢指针到入环处时快指针已经入环并走了了，所以实际情况一定会在第一圈之内相遇。
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null)
                return null;
            ListNode slow = head;
            ListNode fast = head;
            //fast跑的比slow快，当fast为null时，表示链表不是还
            while (fast != null) {
                //slow移一步
                slow = slow.next;
                if (fast.next != null) {
                    //fast的下一个元素不为空时，fast移两步
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (fast == slow) {
                    //两者相遇，这里新建一个列表从头开始，等待与slow相遇
                    ListNode tmp = head;
                    while (tmp != slow) {
                        tmp = tmp.next;
                        slow = slow.next;
                    }
                    return tmp;
                }
            }
            return null;
        }

        /**
         * 用set解决
         * @param head
         * @return
         */
        public ListNode detectCycle1(ListNode head) {
            ListNode cur = head;
            Set<ListNode> nodeSet = new HashSet<>();
            while (cur != null) {
                if (nodeSet.contains(cur)) {
                    return cur;
                }
                nodeSet.add(cur);
                cur = cur.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
