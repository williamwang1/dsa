public class LL_Reverse_Linked_List_II {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;


        // find Node(m -1), how ?
        // 1 --> from dummy to Node(1)
        // ......
        // m - 1 ---> from Node(m - 2) to Node(m -1)
        for (int i = 1; i < m; i++) {

            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next;

        // when i = m, reverse postnNode and nNode, postnNode is cur in normal reverse
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;
        // m  reverse Node(m)(prev) and Node(m + 1)(cur)
        //    after reverse Node(m + 1)(prev), Node(m + 2)(cur)
        // n - 1  reverse Node(n -1)(prev) and Node(n)(cur)
        //     after reverse Node(n)(prev), Node(n + 1) cur;
        for(int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode next = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = next;
        }



        // pervious start n
        premNode.next = nNode;
        // endNode.next
        mNode.next = postnNode;

        return dummy.next;
    }
}

// dummy node
// find m, prem,
// reverse m to n
// perm. next = n , n.next = m

/**
 *1.  Find Node(m -1)
 * 					1 --> from dummy to Node(1)
 * 					 ......
 * 						m - 1 ---> from Node(m - 2) to Node(m -1)
 * 3.  reverse m to n
 *
 * 				m  reverse Node(m)(prev) and Node(m + 1)(cur)
 *              after reverse Node(m + 1)(prev), Node(m + 2)(cur)
 *         n - 1  reverse Node(n -1)(prev) and Node(n)(cur)
 * 							after reverse Node(n)(prev), Node(n + 1) cur;
 * 5.  connect reversed list with previous
 * 				previous new start . next
 * 				new edn. next
 *
 * */

// http://www.lintcode.com/problem/reverse-linked-list-ii/
// http://www.jiuzhang.com/solutions/reverse-linked-list-ii/

