public class BS_A_Questions {

    /**
     * 二叉树的高度是多少？
     * 最坏 O(n) 最好 O(logn)
     * 一般用 O(h) 来表示更合适
     *
     *  第一类考察形态：求值，求路径类二叉树问题
     *  http://www.lintcode.com/problem/subtree-with-maximum-average/
     *
     *  Maximum Depth of Binary Tree
     * http://www.lintcode.com/problem/maximum-depth-of-binary-tree/
     * http://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
     * Divide Conquer vs Traverse
     *
     * Minimum Subtree
     * http://www.lintcode.com/problem/minimum-subtree/
     * http://www.jiuzhang.com/solutions/minimum-subtree/
     * 求和最小的子树
     *
     * Binary Tree Paths
     * http://www.lintcode.com/problem/binary-tree-paths/
     * http://www.jiuzhang.com/solutions/binary-tree-paths/
     * 求从根（root）到叶（leaf）的所有路径
     *
     * Lowest Common Ancestor
     * http://www.lintcode.com/problem/lowest-common-ancestor/
     * http://www.jiuzhang.com/solutions/lowest-common-ancestor/
     * with parent pointer vs no parent pointer
     * follow up: LCA II & III
     *
     * Binary Tree Longest
     * Consecutive Sequence
     * http://www.lintcode.com/problem/binary-tree-longest-consecutivesequence/
     * http://www.jiuzhang.com/solutions/binary-tree-longest-consecutive
     * -sequence/
     * follow up: BT LCS II & III
     *
     * Binary Tree Path Sum
     * I && II && III
     * http://www.lintcode.com/problem/binary-tree-path-sum/
     * http://www.lintcode.com/problem/binary-tree-path-sum-ii/
     * http://www.lintcode.com/problem/binary-tree-path-sum-iii/
     *
     * • 第二类考察形态：结构变化类二叉树问题
     * http://www.lintcode.com/problem/invert-binary-tree/
     *
     * Flattern Binary Tree to Linked List
     * http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list/
     * http://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/
     *
     * 第三类考察形态：二叉查找树（Binary Search Tree）类问题
     * http://www.lintcode.com/problem/validate-binary-search-tree/
     *
     * BST 基本性质
     * • 从定义出发：
     * • 左子树都比根节点小
     * • 右子树都不小于根节点
     * • 从效果出发：
     * • 中序遍历 in-order traversal 是“不下降”序列
     * • 如图，中序遍历为 1 2 3 4 5
     * • 性质：
     * • 如果一棵二叉树的中序遍历不是“不下降”序列，则一定不是BST
     * • 如果一棵二叉树的中序遍历是不下降，也未必是BST
     * • 比如下面这棵树就不是 BST，但是它的中序遍历是不下降序列。
     * •  1
     * • / \
     * • 1 1
     *
     * Kth Smallest Element in BST
     * https://www.lintcode.com/problem/kth-smallest-element-in-a-bst/
     * https://www.jiuzhang.com/solution/kth-smallest-element-in-a-bst/
     * 时间复杂度如何分析？
     *
     * Follow up: 二叉树经常被修改
     * 如何优化 kthSmallest 这个操作？
     * 在 TreeNode 中增加一个 counter，代表整个树的节点个数
     * 也可以用一个 HashMap<TreeNode, Integer> 来存储某个节点为代表的子树的节点个数
     * 在增删查改的过程中记录不断更新受影响节点的 counter
     * 在 kthSmallest 的实现中用类似 Quick Select 的算法去找到 kth smallest element
     * 时间复杂度为 O(h)，h 为树的高度。
     *
     * BST的高度是多少
     * 同样是最坏 O(n) 最好 O(logn)
     * 用 O(h) 表示更合适
     * 只有 Balanced Binary Tree (平衡二叉树) 才是 O(logn)
     *
     * Binary Search Tree Iterator
     * http://www.lintcode.com/problem/binary-search-tree-iterator/
     * http://www.jiuzhang.com/solution/binary-search-tree-iterator/
     * 阅读全文并背诵
     *
     * 该 Iterator 算法即 non-recursion 的 inorder traversal，不仅仅适用于 BST，任何 Binary Tree 都可以
     * • stack 中保存一路走到当前节点的所有节点
     * • stack的栈顶 一直存储 iterator 指向的当前节点
     * • hasNext() 只需要判断 stack 是否为空
     * • next() 只需要返回 stack 的栈顶值，并将 iterator 挪到下一个点，对 stack 进行相应的变化
     * 挪到下一个点的算法如下：
     * • 如果当前点存在右子树，那么就是右子树中“一路向左”最左边的那个点
     * • 如果当前点不存在右子树，则是走到当前点的路径中，第一个左拐的点
     * 相关题：
     * http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree/
     * http://www.lintcode.com/problem/validate-binary-search-tree/ 不用递归
     * http://www.lintcode.com/problem/binary-tree-inorder-traversal/ 不用递归
     *
     * Closest Binary Search Tree Value
     * https://www.lintcode.com/problem/closest-binary-search-tree-value/
     * http://www.jiuzhang.com/solution/closest-binary-search-tree-value/
     * 如果使用中序遍历，时间复杂度是多少？
     * 如果使用 lowerBound / upperBound 的方法，时间复杂度是多少？
     *
     * Follow up: 寻找 k 个最接近的值
     * https://www.lintcode.com/problem/closest-binary-search-tree-value-ii/
     * https://www.jiuzhang.com/solution/closest-binary-search-tree-value-ii/
     * 如果是用中序遍历得到从小到大的所有值，接下来的问题相当于之
     * 前学过的哪个题？
     * 有没有更快的办法？
     *
     * • Search Range in Binary Search Tree
     * • http://www.lintcode.com/problem/search-range-in-binary-search-tree/
     * • Insert Node in a Binary Search Tree
     * • http://www.lintcode.com/problem/insert-node-in-a-binary-search-tree/
     * • Remove Node in a Binary Search Tree
     * • http://www.lintcode.com/problem/remove-node-in-binary-search-tree/
     * • http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/BST-delete.html
     *
     请在随课教程中自学如下内容：
     • Morris 算法：使用 O(1) 的额外空间复杂度对二叉树进行先序遍历（Preorder Traversal）
     • 用非递归的方法实现先序遍历，中序遍历和后序遍历
     • 二叉查找树（Binary Search Tree）的增删查改
     • Java 自带的平衡排序二叉树 TreeMap / TreeSet 的介绍和面试中的应用
     *
     * 非递归（Non-recursion or Iteration）版本的中序遍历（Inorder Traversal）
     *
     *
     */
}
