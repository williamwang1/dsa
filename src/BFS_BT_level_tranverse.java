import java.util.*;

/**
 *  1. initialize queue with first element(s)
 *  2. tranverse by level (int size = queen.size() )
 *  3. poll current level element out, if meet condition return if needed
 *  4. put next level elements which meet condition in
 */

public class BFS_BT_level_tranverse {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public List<List    <Integer>> leverOrder (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {    // input null check
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>() ;
        // initialization
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll(); // get elements in current level
                level.add(head.val);
                if (head.left != null) {       // check condition whether valid to put into queue
                    queue.offer(head.left);    // put elements next level in queue
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }

            }
            result.add(level);
        }

        return result;
    }

}


// Q https://www.lintcode.com/problem/binary-tree-level-order-traversal/
// A https://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/

//
//    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//        考点：
//
//        二叉树的层次遍历
//        For example:
//        Given binary tree {3,9,20,#,#,15,7},
//        3
//        / \
//        9 20
//        / \
//        15 7
//        return its level order traversal as:
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]
//        分析:二叉树的层次遍历通常实现方式为使用队列不断压入节点遍历,每次取出队列首个元素遍历左右子节点，继续压入子节点即可。



//// version 1: BFS
//public class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List result = new ArrayList();
//
//        if (root == null) {
//            return result;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            ArrayList<Integer> level = new ArrayList<Integer>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode head = queue.poll();
//                level.add(head.val);
//                if (head.left != null) {
//                    queue.offer(head.left);
//                }
//                if (head.right != null) {
//                    queue.offer(head.right);
//                }
//            }
//            result.add(level);
//        }
//
//        return result;
//    }
//}
//
//
//// version 2:  DFS
//public class Solution {
//    /**
//     * @param root: The root of binary tree.
//     * @return: Level order a list of lists of integer
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> results = new ArrayList<List<Integer>>();
//
//        if (root == null) {
//            return results;
//        }
//
//        int maxLevel = 0;
//        while (true) {
//            List<Integer> level = new ArrayList<Integer>();
//            dfs(root, level, 0, maxLevel);
//            if (level.size() == 0) {
//                break;
//            }
//
//            results.add(level);
//            maxLevel++;
//        }
//
//        return results;
//    }
//
//    private void dfs(TreeNode root,
//                     List<Integer> level,
//                     int curtLevel,
//                     int maxLevel) {
//        if (root == null || curtLevel > maxLevel) {
//            return;
//        }
//
//        if (curtLevel == maxLevel) {
//            level.add(root.val);
//            return;
//        }
//
//        dfs(root.left, level, curtLevel + 1, maxLevel);
//        dfs(root.right, level, curtLevel + 1, maxLevel);
//    }
//}
//
//
//// version 3: BFS. two queues
//public class Solution {
//    /**
//     * @param root: The root of binary tree.
//     * @return: Level order a list of lists of integer
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if (root == null) {
//            return result;
//        }
//
//        List<TreeNode> Q1 = new ArrayList<TreeNode>();
//        List<TreeNode> Q2 = new ArrayList<TreeNode>();
//
//        Q1.add(root);
//        while (Q1.size() != 0) {
//            List<Integer> level = new ArrayList<Integer>();
//            Q2.clear();
//            for (int i = 0; i < Q1.size(); i++) {
//                TreeNode node = Q1.get(i);
//                level.add(node.val);
//                if (node.left != null) {
//                    Q2.add(node.left);
//                }
//                if (node.right != null) {
//                    Q2.add(node.right);
//                }
//            }
//
//            // swap q1 and q2
//            List<TreeNode> temp = Q1;
//            Q1 = Q2;
//            Q2 = temp;
//
//            // add to result
//            result.add(level);
//        }
//
//        return result;
//    }
//}
//
//// version 4: BFS, queue with dummy node
//public class Solution {
//    /**
//     * @param root: The root of binary tree.
//     * @return: Level order a list of lists of integer
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if (root == null) {
//            return result;
//        }
//
//        Queue<TreeNode> Q = new LinkedList<TreeNode>();
//        Q.offer(root);
//        Q.offer(null); // dummy node
//
//        List<Integer> level = new ArrayList<Integer>();
//        while (!Q.isEmpty()) {
//            TreeNode node = Q.poll();
//            if (node == null) {
//                if (level.size() == 0) {
//                    break;
//                }
//                result.add(level);
//                level = new ArrayList<Integer>();
//                Q.offer(null); // add a new dummy node
//                continue;
//            }
//
//            level.add(node.val);
//            if (node.left != null) {
//                Q.offer(node.left);
//            }
//            if (node.right != null) {
//                Q.offer(node.right);
//            }
//        }
//
//        return result;
//    }
//}