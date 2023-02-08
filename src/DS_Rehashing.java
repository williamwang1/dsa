import java.util.*;

public class DS_Rehashing {

    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int newSize = hashTable.length * 2;
        ListNode[] result = new ListNode[newSize];
        for (ListNode node : hashTable) {
            while (node != null) {
                int newIndex = (node.val % newSize + newSize) % newSize;
                if (result[newIndex] == null) {
                    result[newIndex] = new ListNode(node.val);
                } else {
                    ListNode elementHead = result[newIndex];
                    while (elementHead.next != null) {
                        elementHead = elementHead.next;
                    }
                    elementHead.next = new ListNode(node.val);
                }
                node = node.next;
            }
        }
        return result;
    }
}

//    Rehashing 当hash不够大时怎么办?
//        http://www.lintcode.com/problem/rehashing/
//        http://www.jiuzhang.com/solutions/rehashing/

/**
 *
 * My Steps :
 * 1. get hashTable[0]
 * 2. not null , get first node, calculate new index
 * 3. if null, put as new node in new array, else append to tail
 * 4. repeat 2, node = node.next
 * 5. repeat 1 get next hashTable[1]
 *
 *
 * Note:
 * 1. find tail  while (elementHead.next != null) as end condition
 */