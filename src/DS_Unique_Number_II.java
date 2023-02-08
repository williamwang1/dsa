import java.util.*;

public class DS_Unique_Number_II {

    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Map<Integer, Integer> keyToFre;
    Queue<Integer> queue ;

    public DS_Unique_Number_II() {
        // do intialization if necessary
        keyToFre = new HashMap<>();
        queue = new LinkedList<>();
    }
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        queue.add(num);
        if (keyToFre.containsKey(num)) {
            keyToFre.put(num, keyToFre.get(num) + 1);
        } else {
            keyToFre.put(num, 1);
        }

    }

    /**
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        // write your code here
        while (keyToFre.get(queue.peek()) > 1) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek();
        }

    }

    /**
     *
     * hashmap + linkedlist solution incomplete
     */
//    public class ListNode {
//        int key;
//        int val;
//        ListNode next;
//        public ListNode(int key, int val) {
//            this.key = key;
//            this.val = val;
//            this.next = null;
//        }
//    }
//
//    Map<Integer, ListNode> keyToPrev;
//    Set<Integer> duplicates;
//    ListNode dummy;
//    ListNode tail;
//
//    public DS_Unique_Number_II() {
//        // do intialization if necessary
//        keyToPrev = new HashMap<>();
//        duplicates = new HashSet<>();
//        this.dummy = new ListNode(0, 0);
//        this.tail = this.dummy;
//    }
//    /**
//     * @param num: next number in stream
//     * @return: nothing
//     */
//    public void add(int num) {
//        // write your code here
//        if (keyToPrev.containsKey(num)) {
//            // move to end, add into duplicates
//            ListNode pre = keyToPrev.get(num);
//            ListNode cur = pre.next;
//            pre.next = cur.next;
//            if (cur.next != null) {
//                keyToPrev.put(cur.next.val, pre);
//            }
//
//            tail.next = cur;
//            cur.next = null;
//            keyToPrev.put(cur.val, tail);
//
//            tail = cur;
//            duplicates.add(num);
//        } else {
//            // else attach to head, add to map
//            ListNode temp = dummy.next;
//            ListNode newhead = new ListNode(num, num);
//            dummy.next = newhead;
//            newhead.next = temp;
//            keyToPrev.put(num, dummy);
//            if (temp != null) {
//                keyToPrev.put(temp.val, newhead);
//            }
//
//        }
//
//
//    }
//
//    /**
//     * @return: the first unique number in stream
//     */
//    public int firstUnique() {
//        // write your code here
//        if (dummy.next != null) {
//            if (duplicates.contains(dummy.next.key)) {
//                return -1;
//            }
//        }
//        return dummy.next.val;
//    }
}


// https://www.jiuzhang.com/solution/first-unique-number-in-data-stream-ii/#tag-other

/**
 * Steps:
 * 1. add to queue, update keyToFre map
 * 2. get duplicates out of queue
 * 3. result handling, if queue is empty not found,
 *
 * My thought :
 * data structrue selection ?
 * unique number --> hashmap
 * first unique --> linkedlist, arraylist
 * need to delete and mov --> linkedlist
 */

