import java.util.*;

public class BT_Substree_With_Maximum_Average {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public class ResultType {
        public TreeNode subtree;
        public int sum;
        public int size;
        public ResultType(int size,int sum,TreeNode subtree) {
            this.size = size;
            this.sum = sum;
            this.subtree = subtree;
        }
    }

    private ResultType result = new ResultType(0, 0, null);

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return result.subtree;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, root);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        ResultType resultType = new ResultType(left.size + right.size + 1,
                root.val + left.sum + right.sum, root);

        if (result.subtree == null || resultType.sum * result.size > result.sum * resultType.size) {
            result = resultType;
        }

        return resultType;
    }
}

// left sum size node, right sum size node
// get root sum size node from left, right
// assign global variable value or vaupdate global result type iif greater


// http://www.lintcode.com/problem/subtree-with-maximum-average/
//        http://www.jiuzhang.com/solutions/subtree-with-maximum-average/

// With Global variable, no need to handle left and right tree separately, only single root node