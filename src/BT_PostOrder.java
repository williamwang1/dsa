import java.util.*;

public class BT_PostOrder {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
           this.val = val;
           this.left = this.right = null;
       }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}

/**
 * expected order :left --> right --> root
 *
 * Steps :
 * stack push root -> left -right
 * stack pop  root -> right--> left, then reverse the results
 */