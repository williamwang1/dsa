import java.util.*;

public class BFS_topological_sorting {

    public static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        public DirectedGraphNode(int label) {
            this.label = label;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void main (String[] agrs) {
        DirectedGraphNode zero = new DirectedGraphNode(0);
        DirectedGraphNode one = new DirectedGraphNode(1);
        DirectedGraphNode two = new DirectedGraphNode(2);
        DirectedGraphNode three = new DirectedGraphNode(3);
        DirectedGraphNode four = new DirectedGraphNode(4);
        DirectedGraphNode five = new DirectedGraphNode(5);
        zero.neighbors.add(one);
        zero.neighbors.add(two);
        zero.neighbors.add(three);
        one.neighbors.add(four);
        two.neighbors.add(four);
        two.neighbors.add(five);
        three.neighbors.add(four);
        three.neighbors.add(five);
        ArrayList inputs = new ArrayList<>();
        inputs.add(three);
        inputs.add(five);
        inputs.add(four);
        inputs.add(zero);
        inputs.add(one);

        BFS_topological_sorting topsort = new BFS_topological_sorting();
        ArrayList<DirectedGraphNode> result = topsort.topSort(inputs);
        for (DirectedGraphNode node : result) {

            System.out.println(node.label);
        }

    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList result = new ArrayList<DirectedGraphNode>();
        if (graph == null) {
            return result;
        }

        Map<DirectedGraphNode, Integer> map = new HashMap<>();

        // get all nodes which indegree > 0
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode n : node.neighbors) {
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();

        // put nodes which = 0 into queue and result
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        // decrease indegree of node neighbors, put into queue and result if 0
        while (!queue.isEmpty()) {
            DirectedGraphNode head = queue.poll();
            for (DirectedGraphNode node : head.neighbors) {
                map.put(node, map.get(node) - 1);
                if (map.get(node) == 0) {
                    queue.offer(node);
                    result.add(node);
                }
            }
        }
        return result;
    }


//  DFS
//    设置HashMap存所有入度不为0的节点信息。
//    结合HashMap和图，找到所有入度为0的点，一个一个的进行拓扑遍历。
//    假定给顶点关系为A -> B，为了保证A在最后的结果中排在B的前面， 设置一个Stack, 用类似从树的根节点出发走到叶子节点的方式遍历（dfs），然后再把叶子节点放到stack里，因为叶子节点先入栈，父节点后入栈， 所以到最后pop的时候父节点反倒现出来。满足拓扑排序的定义。
//    boolea[] visited数组是用来记录哪个节点被访问过，为了防止重复，(一个节点可能会有多个节点指向它）所以每次访问完一个节点后就将其对应在visited[]数组里的值改为true.


//    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
//        ArrayList<DirectedGraphNode> result = new ArrayList<>();
//        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
//
//        int sumOfNode = 0;
//        for(DirectedGraphNode node : graph) {
//            for(DirectedGraphNode n : node.neighbors) {
//                sumOfNode += 1;
//                if(!map.containsKey(n)) {
//                    map.put(n, 1);
//                } else {
//                    map.put(n, map.get(n) + 1);
//                }
//            }
//        }
//
//        boolean[] visited = new boolean[sumOfNode];
//        Stack<DirectedGraphNode> stack = new Stack<>();
//
//        for(DirectedGraphNode node : graph) {
//            if(map.containsKey(node)) {
//                continue;
//            }//else
//            //for loop 所有入度为0 的点
//            dfsHelper(node, visited, stack);
//        }
//
//        while(!stack.isEmpty()) {
//            result.add(stack.pop());
//        }
//        return result;
//    }
//
//    private void dfsHelper(DirectedGraphNode n, boolean[] visited, Stack<DirectedGraphNode> stack) {
//        //mark visited[n.label] as true or accessed
//        visited[n.label] = true;
//
//        for(DirectedGraphNode neighbor: n.neighbors) {
//            if(visited[neighbor.label]) {
//                continue;
//            }
//            dfsHelper(neighbor, visited, stack);
//        }
//        stack.push(n);
//    }
}


// http://www.lintcode.com/problem/topological-sorting/
// http://www.jiuzhang.com/solutions/topological-sorting/
// 几乎每个公司都有一道拓扑排序的面试题! 问:可以使用 DFS 来做么?
