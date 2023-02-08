import  java.util.*;

public class BT_PreOrder {
       public class TreeNode {
           public int val;
           public TreeNode left, right;

           public TreeNode(int val) {
               this.val = val;
               this.left = this.right = null;
           }
       }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // public List<Integer> preorderTraversal(TreeNode root) {
    //     // write your code here
    //     List<Integer> result = new ArrayList<>();
    //     helper(root, result);
    //     return result;
    // }


    // private void helper(TreeNode root, List<Integer> result) {
    //     if (root == null) {
    //         return;
    //     }
    //     result.add(root.val);
    //     helper(root.left, result);
    //     helper(root.right, result);
    // }
}


// tranverse

// 1. recursion definition
// 把root 为根的preorder 放到result 里面

// 2. recusion step
// turn big problem into small problem
// put root into results
// put left substree into results
// put right substree into results;

/**
 * Steps :
 * Recursion define : 以 root 为根节点的所有树的节点，把结果放到result 里面
 * Recursion steps :
 *      root.value 放到result 里面, 遍历左子树，遍历右子树
 * Recursion end condition: root 为空 结束
 *
 * Non Recursion
 * 1. nitial put root into stack
 * 2. pop element out
 * 3. put right node first, then left node inside stack
 * 4. till stack is empty
 *
 * */
