public class LL_Reverse_Linked_List {

}

// https://www.lintcode.com/problem/reverse-linked-list

/*
head != null  // end condition

ListNode next = head.next;    // record current node next pointer to move current node to next

head.next = prev;  // move current next pointer to previous

prev = head;   //  move previous to current

head = next;  //  move current to next

return prev;  // need to return cur, but cur is changed to prev already
* */