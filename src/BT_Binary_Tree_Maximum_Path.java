public class BT_Binary_Tree_Maximum_Path {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int curMax = Math.max(left + root.val, right + root.val);
        curMax = Math.max(curMax, root.val);
        //curMax = Math.max(curMax, left + right + root.val);
        // ????
        max = Math.max(Math.max(curMax, left + right + root.val), max);
        return curMax;
    }
}

// https://www.lintcode.com/problem/binary-tree-maximum-path-sum/description

/**
*
* 有4种情况要考虑
 * left + root
 * right + root
 * root
 * left + right + root
 * 不断往上传递的值 只可能是 1， 2， 3中的一种
 * 第四种情况只可能保存在 max里面 而不可能在 curr_max ???
 *
 * curr_max是上传到上一级用的 在上一级 可以用左边的和右边的路径再组合 但是第四种情况是已经穿过root的路径 到上一级就用不了了 不可能跟上一级的root在一起组成新的路径了 所以用于更新max以后就不能用了
 *
* */