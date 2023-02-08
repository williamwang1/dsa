import  java.util.*;
public class BT_Balanced_Binary_Tree {

    public class TreeNode {
       public int val;
       public TreeNode left, right;
       public TreeNode(int val) {
           this.val = val;
           this.left = this.right = null;
       }
  }

    public class Result {
        int depth;
        boolean isBalanced;
        public Result(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        Result result = helper(root);
        return result.isBalanced;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, true);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        int depth = Math.max(left.depth, right.depth) + 1;
        Result result = new Result(depth, true);

        if(!left.isBalanced) {
            //result.depth = -1;
            result.isBalanced = false;
            //return new Result(-1, false);
        }

        if(!right.isBalanced) {
            //return new Result(-1, false);
            //result.depth = -1;
            result.isBalanced = false;
        }
        if (Math.abs(left.depth - right.depth) > 1) {
            //result.depth = -1;
            result.isBalanced = false;
            //return new Result(-1, false);
        }
        //return new Result(Math.max(left.depth, right.depth) + 1, true);
        return result;
    }

}


//        http://www.lintcode.com/problem/balanced-binary-tree/
//        http://www.jiuzhang.com/solutions/balanced-binary-tree/
//        When we need ResultType?

// return value is more than 1
