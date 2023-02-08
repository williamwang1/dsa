import java.util.*;

public class BT_Minimum_Subtree {

    public class TreeNode {
         public int val;
         public TreeNode left, right;
         public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
         }
    }

    public class ResultType {
        public TreeNode substree;
        public int miniSum;
        public int sum;
        public ResultType(TreeNode substree, int miniSum, int sum) {
            this.substree = substree;
            this.miniSum = miniSum;
            this.sum = sum;
        }
    }


    public TreeNode findSubtree(TreeNode root) {
        ResultType result = helper(root);
        return result.substree;
    }


    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(root, Integer.MAX_VALUE, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // substree contain root
        // minisum is sum of the whole tree
        ResultType result = new ResultType(root,
                left.sum + right.sum + root.val,
                left.sum + right.sum + root.val);
        if (left.miniSum <= result.miniSum) {
            // why new ResultType is not correct ???
            // result = new ResultType(left.substree, left.miniSum, left.sum);
            result.miniSum = left.miniSum;
            result.substree = left.substree;
        }

        if (right.miniSum <= result.miniSum) {
            // why new ResultType is not correct ???
            //result = new ResultType(right.substree, right.miniSum, right.sum);
            result.miniSum = right.miniSum;
            result.substree = right.substree;
        }
        return result;


        //     TreeNode subtree = null;
//     int miniSum = Integer.MAX_VALUE;
//     public TreeNode findSubtree(TreeNode root) {
//         // write your code here

//         // current node return sum
//         helper(root);
//         return subtree;
//     }

//     // return sum when current node is node
//     private int helper (TreeNode node) {
//         // end condition, null pointer if missing
//         if (node == null) {
//             return 0;
//         }
//         // get sum
//         int sum = helper(node.left) + helper(node.right) + node.val;
//         //update minisum and subtree node
//         if (sum < miniSum) {
//             miniSum = sum;
//             subtree = node;
//         }
//         return sum;
//     }
    }
}


//public class Solution {
//
//    public class ResultType {
//        public TreeNode subtree;
//        public int sum;
//        public ResultType(TreeNode subtree, int sum) {
//            this.subtree = subtree;
//            this.sum = sum;
//        }
//    }
//
//    ResultType result = new ResultType(null, Integer.MAX_VALUE);
//    public TreeNode findSubtree(TreeNode root) {
//        helper(root);
//        return result.subtree;
//    }
//
//
//    private ResultType helper(TreeNode root) {
//        if (root == null) {
//            return new ResultType(root, 0);
//        }
//
//        ResultType left = helper(root.left);
//        ResultType right = helper(root.right);
//
//
//        ResultType resultType = new ResultType(root, left.sum + right.sum + root.val);
//        // result.subtree == null--> handle only one root node
//        if (result.subtree == null || resultType.sum <= result.sum) {
//            result = resultType;
//        }
//        return resultType;
//    }
//}


// http://www.lintcode.com/en/problem/minimum-subtree/
//        http://www.jiuzhang.com/solutions/minimum-subtree/
//        Traverse + Divide Conquer 课后作业:只用 Divide Conquer 来实现

/**
 * ResultType --> 根节点, 以root 为根的sum
 * Global variable ResultType
 *
 * */