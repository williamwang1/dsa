public class BFS_A_template {

/**
 * Binary Tree Level Order Traversal
 * http://www.lintcode.com/problem/binary-tree-level-order-traversal/
 * http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
 *
 *
 * Binary Tree Serialization
 * 算法描述:
 * http://www.lintcode.com/en/help/binary-tree-representation/
 * 题目及解答:
 * http://www.lintcode.com/en/problem/binary-tree-serialization/
 * http://www.jiuzhang.com/solutions/binary-tree-serialization/
 *
 *
 *
 * */

//    // 计算从起点 start 到终点 target 的最近距离
//    int BFS(Node start, Node target) {
//        Queue<Node> q; // 核心数据结构
//        Set<Node> visited; // 避免走回头路
//
//        q.offer(start); // 将起点加入队列
//        visited.add(start);
//        int step = 0; // 记录扩散的步数
//
//        while (q not empty) {
//            int sz = q.size();
//            /* 将当前队列中的所有节点向四周扩散 */
//            for (int i = 0; i < sz; i++) {
//                Node cur = q.poll();
//                /* 划重点：这里判断是否到达终点 */
//                if (cur is target)
//                return step;
//                /* 将 cur 的相邻节点加入队列 */
//                for (Node x : cur.adj())
//                    if (x not in visited) {
//                    q.offer(x);
//                    visited.add(x);
//                }
//            }
//            /* 划重点：更新步数在这里 */
//            step++;
//        }
//    }


    // initialize visited if needed
    // initialize elements in queue
    // while (a not empty) {
    //     poll current element
    //     return condition if any
    //     skip element if any
    //     loop adj elements of current {
    //          skip any element which meet skip condition
    //          put into queue if condition meet
    //          chane into visited if any
    //     }
    //
    // }
}

// when to use BFS ?
// Traversal in Graph
    // Level Order Traversal
    // Connected Component
    // Topological Sorting
// Shortest Path in Simple Graph
    // Simple Graph ? undirected graph, equal each side

// implicit Graph
