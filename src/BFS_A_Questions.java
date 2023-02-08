public class BFS_A_Questions {

//图的遍历 Traversal in Graph
//• 层级遍历 Level Order Traversal
//• 由点及面 Connected Component
//• 拓扑排序 Topological Sorting
//最短路径 Shortest Path in Simple Graph
//• 仅限简单图求最短路径
//• 即，图中每条边长度都是1，或者边长都相等
// 非递归的方式找所有方案 Iteration solution for all possible results
//• 这一点我们将在后面 DFS 的课上提到

//    最短路径
//    简单图 → BFS
//    复杂图 → Dijkstra, SPFA, Floyd（一般面试不考这个）
//    最长路径
//    图可以分层 → Dynamic Programming
//    分层：比如走到第i一定会经过第 i-1 层（棋盘格子图是典型的例子）
//    不可以分层 → DFS
/**
 *  算法描述：
 *     http://www.lintcode.com/en/help/binary-tree-representation/
 *     题目及解答：
 *     http://www.lintcode.com/en/problem/binary-tree-serialization/
 *     http://www.jiuzhang.com/solutions/binary-tree-serialization/
 *
 *     Binary Tree Level Order Traversal II
 * http://www.lintcode.com/en/problem/binary-tree-level-order-traversal-ii/
 * http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal-ii/
 * Binary Tree Zigzag Order Traversal
 * http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/
 * http://www.jiuzhang.com/solutions/binary-tree-zigzag-level-order-traversal/
 * Convert Binary Tree to Linked Lists by Depth
 * http://www.lintcode.com/en/problem/convert-binary-tree-to-linked-lists-by-depth/
 * http://www.jiuzhang.com/solutions/convert-binary-tree-to-linked-lists-by-depth/
 *
 * 图上的宽度优先搜索
 * BFS in Graph
 * 问：和树上有什么区别？
 * 哈希表
 * 图中存在环
 * 存在环意味着，同一个节点可能重复进入队列
 * Java: HashMap / HashSet
 * C++: unordered_map / unordered_set
 * Python: dict / set
 *
 * Clone Graph (F)
 * http://www.lintcode.com/problem/clone-graph/
 * http://www.jiuzhang.com/solutions/clone-graph/
 * 图的遍历（由点及面）
 *
 * BFS 的时间复杂度
 * O(N + M)
 * 其中 N 为点数，M 为边数
 *
 * Word Ladder
 * http://www.lintcode.com/problem/word-ladder/
 * http://www.jiuzhang.com/solution/word-ladder/
 * 最典型的BFS问题 —— 隐式图 (Implicit Graph) 最短路径
 *
 * 矩阵中的宽度优先搜索
 * BFS in Matrix
 *
 * 图 Graph
 * N个点，M条边
 * M最大是 O(N^2) 的级别
 * 图上BFS时间复杂度 = O(N + M)
 * • 说是O(M)问题也不大，因为M一般都比N大
 * 所以最坏情况可能是 O(N^2)
 * 矩阵 Matrix
 * R行C列
 * R*C个点，R*C*2 条边（每个点上下左右4条边，每条边被2个点共享）。
 * 矩阵中BFS时间复杂度 = O(R * C)
 *
 * Number of Islands
 * http://www.lintcode.com/problem/number-of-islands/
 * http://www.jiuzhang.com/solutions/number-of-islands/
 * 图的遍历（由点及面）
 *
 * Knight Shortest Path
 * http://www.lintcode.com/problem/knight-shortest-path/
 * http://www.jiuzhang.com/solutions/knight-shortest-path/
 * 简单图最短路径
 * follow up: speed up?（见随课教程）
 *
 * 拓扑排序 Topological Sorting
 * 入度（In-degree）：
 * 有向图（Directed Graph）中指向当前节点的点的个数（或指向当前节点的边的条数）
 * 算法描述：
 * 1. 统计每个点的入度
 * 2. 将每个入度为 0 的点放入队列（Queue）中作为起始节点
 * 3. 不断从队列中拿出一个点，去掉这个点的所有连边（指向其他点的边），其他点的相应的入度 - 1
 * 4. 一旦发现新的入度为 0 的点，丢回队列中
 * 拓扑排序并不是传统的排序算法
 * 一个图可能存在多个拓扑序（Topological Order），也可能不存在任何拓扑序
 *
 * Topological Sorting
 * http://www.lintcode.com/problem/topological-sorting/
 * http://www.jiuzhang.com/solutions/topological-sorting/
 * 该问题保证一定存在至少一个拓扑序
 *
 * 求任意1个拓扑序（Topological Order）
 * 问是否存在拓扑序（是否可以被拓扑排序）
 * 求所有的拓扑序 DFS
 * 求是否存在且仅存在一个拓扑序 Queue中最多同时只有1个节点
 *
 * Course Schedule I && II (GAFZ)
 * http://www.lintcode.com/problem/course-schedule/
 * http://www.lintcode.com/problem/course-schedule-ii/
 * 换了个皮，第二问需要判断是否没有拓扑序
 *
 * Alien Dictionary (GFTSAP)
 * http://www.lintcode.com/problem/alien-dictionary/
 * http://www.jiuzhang.com/solution/alien-dictionary/
 * 相似问题：http://www.lintcode.com/problem/sequence-reconstruction/
 * 考点1：如何构建图
 * 考点2：如何存储图
 * 考点3：如何拓扑排序
 *
 * 图上的BFS
 * • 判断一个图是否是一棵树
 * • http://www.lintcode.com/problem/graph-valid-tree/
 * • 搜索图中最近值为target的点
 * • http://www.lintcode.com/problem/search-graph-nodes/
 * • 无向图联通块
 * • http://www.lintcode.com/problem/connected-component-in-undirected-graph/
 * • 序列重构（判断是否只有一个拓扑排序）
 * • http://www.lintcode.com/problem/sequence-reconstruction/
 * • 矩阵上的BFS
 * • 僵尸多少天吃掉所有人
 * • http://www.lintcode.com/problem/zombie-in-matrix/
 * • 建邮局问题 Build Post Office II
 * • http://www.lintcode.com/problem/build-post-office-ii/
 *
 *
 */



}
