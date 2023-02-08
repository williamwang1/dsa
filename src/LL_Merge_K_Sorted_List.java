public class LL_Merge_K_Sorted_List {
}


// http://www.lintcode.com/problem/merge-k-sorted-lists/
//http://www.jiuzhang.com/solutions/merge-k-sorted-lists/
//PriorityQueue/Heap vs Divide Conquer

// k 个数里面找最小 heap
// Time complexity nLog , n--> 所有链表长度之和
// heap 操作 log heap size


// divide & conquer
// merge k/2 seperately
// Time Complexity : 树形分析法， 每一层节点个数是O(N)(也就是总结点个数) 总共 log K 层， 所以 Nlog K

