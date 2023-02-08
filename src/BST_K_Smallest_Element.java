public class BST_K_Smallest_Element {

}

// https://www.jiuzhang.com/solution/kth-smallest-element-in-a-bst/

/**
 * Follow up: 二叉树经常被修改 如何优化 kthSmallest 这个操作?
 *
 * Map 维护 TreeNode  NoofNodes 关系
 *
 * left + 1 = k return root.val
 *
 * left > k, 继续在left 侧找k
 *
 * left < k, 在right 侧找 k - left - 1 (left 为左子树节点数量，1 为root)
 */
