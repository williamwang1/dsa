import java.util.*;

public class BT_BInary_Tree_Path_Sum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, target, root.val, path, result);
        return result;
    }

    private void helper(TreeNode root, int target, int sum, List<Integer> path, List<List<Integer>> result) {

        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if (root. left != null) {
            path.add(root.left.val);
            helper(root.left, target, sum + root.left.val, path, result);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, target, sum + root.right.val, path, result);
            path.remove(path.size() - 1);
        }
    }
}

// from root to leaft

// all paths add to target

/**
 * recursion definiton
 * 以root 为根节点,  以path 开头的, sum == target 的集合，并把结果放到result 里面
 *
 * steps :
 * 左子树存在 遍历左子树
 * 右子树存在 遍历右子树
 *
 * end
 * 叶子节点 并且 target == sum
 *
 * */