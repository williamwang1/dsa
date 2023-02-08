import java.util.*;

/**
 *
 * deserialize
 *
 * 1. initialize put root node into queue and index = 1
 * 2. not null ? cur.left and move index next
 * 3. not null ? cur. right
 */

public class BFS_binary_tree_representation {

    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        // StringBuilder ans = new StringBuilder();
        sb.append("{");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#");
                sb.append(",");
                continue;
            } else {
                sb.append(node.val + "");
                sb.append(",");
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        // while (sb.length() - 1 == "#") {
        //     sb.deleteChartAt(sb.length() - 1);
        // }
        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            if (!vals[i].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(cur.left);
            }
            i++;
            if (!vals[i].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(cur.right);
            }
            i++;
        }

        return root;
    }
}


// https://www.lintcode.com/help/binary-tree-representation/

// http://www.jiuzhang.com/solutions/binary-tree-serialization/