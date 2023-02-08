import java.time.temporal.Temporal;
import java.util.*;


public class BT_Binary_Tree_Paths {


    public static void main (String[] argus) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        BT_Binary_Tree_Paths bp = new BT_Binary_Tree_Paths();
        List<String> result = bp.binaryTreePaths(root);
        for (String s: result) {
            System.out.println(s);
        }
    }

    // public class Solution {
//     /**
//      * @param root: the root of the binary tree
//      * @return: all root-to-leaf paths
//      */
//     public List<String> binaryTreePaths(TreeNode root) {
//         // write your code here
//         List<String> paths = new ArrayList<String>();
//         if (root == null) {
//             return paths;
//         }

//         helper(root, String.valueOf(root.val), paths);

//         return paths;
//     }

//     // recursion definition, current node, path string, put string into paths
//     private void helper(TreeNode root, String path, List<String> paths) {

//         // when node is leaf node, stop and put path into paths
//         if (root.left == null && root.right == null) {
//             paths.add(path);
//             return;
//         }

//         // current node is root left node , get path string and put into paths
//         if (root.left != null) {
//             helper(root.left, path + "->" + root.left.val, paths);
//         }

//         // current node is root right node, get path string and put into paths
//         if (root.right != null) {
//             helper(root.right, path + "->" + root.right.val, paths);
//         }

//     }
// }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        if (leftPaths.size() == 0 && rightPaths.size() == 0) {
            paths.add(String.valueOf(root.val));
        }

        // ????
        // 回溯的过程，先 5 - > 2, 然后 1 -> 5 -> 2
        for (String left : leftPaths) {
            paths.add(root.val + "->" + left);
        }

        //????
        for (String right : rightPaths) {
            paths.add(root.val + "->" + right);
        }

        return paths;
    }
}

/**
 * Q 以root 根节点的所有路径 与 以root.left 为根节点的所有路径的关系是？
 *   root.val + "->" + 以root.left 为根的每一条路径
 * Note：当左右节点为空时，路径只是根节点
 *
 */

// https://www.jiuzhang.com/solution/binary-tree-paths/
