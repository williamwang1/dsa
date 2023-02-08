public class BST_Remove_Node {
}

/**
 *
 * Q : swap max in left subtree or min in right substree
 *
 * dummy tree Node
 *
 * find node which value equal target, return node's parent
 * get node from node's parent
 *  node = parent.left/ node = parent.right/ can not finde, 不做处理
 * delete node
 *
 *
 * 递归
 * 三种大情况
 *
 * 节点的值大于目标，那么去右子树去删除节点
 * 小于目标，去左子树
 * 等于目标
 * a 节点是叶子，直接删除节点即可
 * b 节点只有一个子节点，那么就让这个子节点代替节点
 * c 节点有两个子节点，我的方案是找到左子节点的最大值，然后将其替换给当前节点，然后删掉那个最大值的左侧节点
 *
 */
