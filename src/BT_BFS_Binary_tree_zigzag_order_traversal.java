import  java.util.*;

public class BT_BFS_Binary_tree_zigzag_order_traversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here

        // reverse even order elements

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> levelElements = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                levelElements.add(cur.val);
            }
            if (level % 2 == 0) {  // odd level reverse elements in the list

                Collections.reverse(levelElements);
            }
            result.add(levelElements);
            level++;
        }
        return result;
    }
}


// http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/
// http://www.jiuzhang.com/solutions/binary-tree-zigzag-level-order-traversal/