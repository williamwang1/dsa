public class BT_Max_Depth_Binanry_Tree {

     public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return maxDepth;
    }

    // current node, current level;
    // update global max depth during recursion
    private void helper(TreeNode root, int curLevel) {

        // recursion end condition
        if (root == null) {
            return;
        }

        // update maxDepth
        if (curLevel > maxDepth) {
            maxDepth = curLevel;
        }

        // left node, current level
        helper(root.left, curLevel + 1);

        // right node, current levle
        helper(root.right, curLevel + 1);
    }
}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

// public class Solution {
//     /**
//      * @param root: The root of binary tree.
//      * @return: An integer
//      */
//     public int maxDepth(TreeNode root) {
//         // write your code here
//         if (root == null) {
//             return 0;
//         }
//         int leftDepth = maxDepth(root.left);
//         int rightDepth = maxDepth(root.right);

//         return Math.max(leftDepth, rightDepth) + 1;
//     }


// }



// tranverse Global depth, get depth of current node , then update global depth



// http://www.lintcode.com/problem/maximum-depth-of-binary-tree/
       // http://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
       // Related Question: Minimum Depth of Binary Tree

