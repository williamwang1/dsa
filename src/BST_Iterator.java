import java.util.*;

public class BST_Iterator {
    Stack<TreeNode> stack;
    /*
     * @param root: The root of binary tree.
     */public BST_Iterator(TreeNode root) {
        // do intialization if necessary
        stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode peek = stack.peek();
        TreeNode pointer = peek;
        if (pointer.right == null) {
            pointer = stack.pop();
            while(!stack.isEmpty() && pointer == stack.peek().right) {
                pointer = stack.pop();
            }
        } else {
            pointer = pointer.right;
            while (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
        }
        return peek;
    }

}


// http://www.jiuzhang.com/solutions/binary-search-tree-iterator/
/**
 * Q: How to inspire to use stack ?
 *
 * Steps:
 * initialization : make stack peek smallest, get left node until null
 * next:
 * 如果当前点存在右子树，那么就是右子树中“一路向西”最左边的那个点
 * 如果当前点不存在右子树，则是走到当前点的路径中，第一个左拐的点
 * hasnext: !stack.isEmpty
 */
