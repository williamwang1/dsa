import java.util.*;

public class BFS_Clone_Graph {

    public static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        public UndirectedGraphNode(int label) {
            this.label = label;
            this.neighbors = new ArrayList<>();
        }
    }


//    // BFS template clone graph
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        // write your code here
//        //  UndirectedGraphNode result = new UndirectedGraphNode();
//        if (node == null) {
//            return node;
//        }
//
//        Queue<UndirectedGraphNode> queue = new LinkedList<>();
//        // key data structure
//        // store mapping between old node and new node
//        // store node visited
//        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
//        queue.offer(node);
//        map.put(node, new UndirectedGraphNode(node.label));
//
//        while (!queue.isEmpty()) {
//            UndirectedGraphNode head = queue.poll();
//            for (UndirectedGraphNode n : head.neighbors) {
//                if (!map.containsKey(n)) {
//                    queue.offer(n);
//                    map.put(n, new UndirectedGraphNode(n.label));
//                }
//                UndirectedGraphNode newHead = map.get(head);
//                UndirectedGraphNode newneighbor = map.get(n);
//                newHead.neighbors.add(newneighbor);
//
//            }
//        }
//
//    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        //  UndirectedGraphNode result = new UndirectedGraphNode();
        if (node == null) {
            return node;
        }

        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();

        // copy old node value into mapping between new node and old node
        for(UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy the neighbors of old node
        for (UndirectedGraphNode n : nodes) {
            // get copied node
            UndirectedGraphNode newnode = mapping.get(n);
            // loop old node neighbors
            for (UndirectedGraphNode neighbor : n.neighbors) {
                // get new neighbor, add new neighbor to newnode
                UndirectedGraphNode newneighbor = mapping.get(neighbor);
                newnode.neighbors.add(newneighbor);
            }
        }

        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<>(set);
    }


    // DFS
 //   建立一个哈希来储存新老节点的一一对应关系。
 //   把克隆节点的任务丢给dfs函数，默认dfs函数可以搞定：

    // 克隆原始节点
    // 克隆该原始节点的邻居节点，并且利用dfs继续对这些邻居节点进行同样的操作
    // 克隆对应关系
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        return node == null ? node : dfs(node, new HashMap<>());
//    }
//    UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
//        if (map.containsKey(node)) return map.get(node);
//        map.put(node, new UndirectedGraphNode(node.label));
//        for(UndirectedGraphNode neighbor : node.neighbors) {
//            map.get(node).neighbors.add(dfs(neighbor, map));
//        }
//        return map.get(node);
//    }

}


//http://www.lintcode.com/problem/clone-graph/
// http://www.jiuzhang.com/solutions/clone-graph/
// 图的遍历(由点及面)
