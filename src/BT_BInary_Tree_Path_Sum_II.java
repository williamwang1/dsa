
import java.util.*;
public class BT_BInary_Tree_Path_Sum_II {

    // public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
    //     // write your code here
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (root == null) {
    //         return result;
    //     }
    //     List<Integer> path = new ArrayList<>();
    //     path.add(root.val);
    //     helper(root, target, path, result);
    //     return result;
    // }


    // private void helper(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
    //     if (root == null) {
    //         return;
    //     }
    //     int sum = 0;
    //     // why start from end ?
    //     // we need to find paths not started from root
    //     for (int i = path.size() - 1; i >=0; i--) {
    //         int value = path.get(i);
    //         sum = sum + value;
    //         if (sum == target) {
    //             List<Integer> list = new ArrayList<>();
    //             for(int j = i; j < path.size(); j++) {
    //                 list.add(path.get(j));
    //             }
    //             result.add(list);
    //         }
    //     }
    //     if (root.left != null) {
    //         path.add(root.left.val);
    //         helper(root.left, target, path, result);
    //         path.remove(path.size() - 1);
    //     }
    //     if (root.right != null) {
    //         path.add(root.right.val);
    //         helper(root.right, target, path, result);
    //         path.remove(path.size() - 1);
    //     }
    // }

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, target, result);
        return result;
    }

    private void findPaths(TreeNode root, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        findPathsByRoot(root, path, target - root.val, result);
        findPaths(root.left, target, result);
        findPaths(root.right, target, result);

    }

    private void findPathsByRoot(TreeNode root,
                                 List<Integer> path,
                                 int target,
                                 List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            path.add(root.left.val);
            findPathsByRoot(root.left, path, target - root.left.val ,result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            findPathsByRoot(root.right, path, target - root.right.val, result);
            path.remove(path.size() - 1);
        }
    }
}

/**
 * solution 1
 * 以 root 为根的树，path 开头的路径找到满足条件的路径，并将结果加到result 里
 * 条件 sum == target 的以root 开头和不以root 开头的路径
 *
 * solution 2
 * 以root 为根的树 找满足条件的所有path，条件：sum == target, (root 可以为起点， 也可以不为起点)
 * 				以root 为起点的 找满足条件的所有path
 * 						条件 以root 为起点 sum == target 的path
 * 				以root.left 为根的树 找target  == sum 的所有path
 * 				以root.right 为根的树 找target  == sum 的所有path
 *
 * */


// from any to any wtithin same subtree

// all paths add to target