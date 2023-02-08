public class LL_Remove_Duplicates_From_Sorted_List_II {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur != null && cur.next != null && cur.val == cur.next.val) {
                // 不能按照removeElements 那样一个一个删因为cur 在变 cur.val 也跟着变
                // 只能找出来跟cur.val 一样的节点，一次性删除
                int value = cur.val; //
                while (cur != null && cur.val == value) {
                    pre.next = cur.next;
                    cur = cur.next;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode slow = dummy;
//        ListNode fast = head;
//        while (fast != null) {
//            while (fast.next != null && fast.val == fast.next.val) {
//                fast = fast.next;
//            }
//            if (slow.next != fast) {
//                slow.next = fast.next;
//
//            } else {
//                slow = slow.next;
//            }
//            fast = fast.next;
//        }
//        return dummy.next;
//
//    }

}

// pre, cur, next

// 第一个元素没有 pre
//http://www.lintcode.com/problem/reverse-linked-list-ii/
//        http://www.jiuzhang.com/solutions/reverse-linked-list-ii/

/**
可能会有连续多个重复
        h --> hn ---> hnn --> hnnn
        h as prev, hn as cur , hnn as next
        if hn.val == hnn.val  如果有重复，提取重复的值(cur 节点值)，进入循环
        当前节点值与重复值相等 删除节点，
        以此类推，直到当前节点值与重复值不相等，结束循环
        否则
        当前节点向前移动
 */

/**
 * 双指针, slow 指向无重复的点， fast 指向有重复的最后一个点
 * 有重复，循环移动fast
 * 有重复(fast 被移动过) 移动 slow 到 fast.next
 * 没有重复，正常移动slow*/