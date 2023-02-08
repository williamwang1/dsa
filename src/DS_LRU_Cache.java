import  java.util.*;

public class DS_LRU_Cache {

    public class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    Map<Integer, Node> hs = new HashMap<>();
    int capacity;
    Node head = new Node(-1, -1); // dummy head
    Node tail = new Node(-1, -1); // dummy tail
    /*
     * @param capacity: An integer
     */public DS_LRU_Cache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!hs.containsKey(key)) {
            return -1;
        }
        Node cur = hs.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        moveToTail(cur);
        return hs.get(key).value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) { // why hs.constainsKey() not working ????
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            // why not head.next.next.pre = head ????
            // head.next.next.pre will have NullPointerException
            // head.next 此时已经是 head.next.next
            head.next.pre = head;
        }

        Node newNode = new Node(key, value);
        hs.put(key, newNode);
        moveToTail(newNode);

    }

    private void moveToTail(Node cur) {
        cur.pre = tail.pre; // tail.pre <--- cur
        tail.pre.next = cur;      // tail.pre ---> cur
        tail.pre = cur;             // cur <--- tail
        cur.next = tail;            // cur ---> tail
    }
}

/**
 * which one to delete before set if cache is full ?
 * remove head, coz easier than remove from tail
 *
 * why hashmap ?
 * coz key value map , need to use hashmap
 *
 * why linkedlist ?
 * coz least recently used, u need to move element after get, array can not satisfy, need a more flexible data structrue, so choose linkedlist
 *
 * which linkedlist ?
 * doublylinkedlist vs singlylinkedlist, both ok.
 *
 * how to link linkedlist with hashmap ?
 * --doublylinkedlist --hashmap value is ListNode
 * --singlelinkedlist -- hashmap value is prevNode,
 *
 * why prevNode in single linked list?
 * if u store current node, u can not find prev node
 *
 * Node constrcutor, why pre = null, next = null ?
 *
 * initialization, why do we need head, tail two nodes ?
 *
 * move to tail ? why do we need to move between pre tail and tail ? why not move after tail ?
 *
 * set, forget about capacity first, steps ?
 * put into hashmap if exist
 * put into hashmap
 * put into linkedlist bwtween tail.pre and tail
 *
 * set if exist. why hs.constainsKey() not working ?
 *
 * set consider capacity limit , how to know current capacity ? steps ?
 * hashmap,szie
 * remove from hashmap, remove head.next node
 *
 * get , steps ?
 * if key not found
 * else move found node from cur to pre-dummy tail
 *
 *
 *
 * */


