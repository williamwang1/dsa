import java.util.*;

public class BT_Inorder_Tranverse {

      public class TreeNode {
          public int val;
          public TreeNode left, right;

          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}

/**
 * left -> root -> right
 *
 * Steps :
 * 1. root 不为空，压入stack，root = root.left
 * 2. root 为空，栈顶元素出栈，加入结果， root = root.right
 * 3. 结束条件 stack 为空, root 为空
 *
 */