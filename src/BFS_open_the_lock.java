import java.util.*;

public class BFS_open_the_lock {

    public class TreeNode {
        public int val;
        public BFS_BT_level_tranverse.TreeNode left;
        public BFS_BT_level_tranverse.TreeNode right;
    }

    public static void main (String[] args) {
        String[] deads = new String[]{"0201","0101","0102","1212","2002"};
        BFS_open_the_lock b = new BFS_open_the_lock();
        int result = b.BFS("0202", deads);
        System.out.println(result);
    }

    private String plusOne(String cur, int j) {
        char[]ch = cur.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else
            ch[j] += 1;
        return new String(ch);
    }

    private String minusOne(String cur, int j) {
        char[]ch = cur.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else
            ch[j] -= 1;
        return new String(ch);
    }

//    public int TwoQueue(String targe, String[]deadnodes) {
//
//        Queue<String> sQueue = new LinkedList<>();
//        Set<String> sVisited = new HashSet();
//        Queue<String> eQueue = new LinkedList<>();
//    }


    public int BFS(String target, String[] deadends) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            if(s.equals("0000"))
                return -1;
            deads.add(s);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // return condition
                if (cur.equals(target)) {
                    return step;
                }
                // skip
                if (deads.contains(cur)) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    String nextPlus = plusOne(cur, j);
                    if (!visited.contains(nextPlus)) {
                        queue.offer(nextPlus);
                        visited.add(cur);
                    }

                    String nextMinus = minusOne(cur, j);
                    if (!visited.contains(nextMinus)) {
                        queue.offer(nextMinus);
                        visited.add(cur);
                    }

                }
            }
            step ++;
        }

        return -1;
    }

}



// 第一步，我们不管所有的限制条件，不管 deadends 和 target 的限制，就思考一个问题：如果让你设计一个算法，穷举所有可能的密码组合，你怎么做？

// 穷举呗，再简单一点，如果你只转一下锁，有几种可能？总共有 4 个位置，每个位置可以向上转，也可以向下转，也就是有 8 种可能对吧。

// 仔细想想，这就可以抽象成一幅图，每个节点有 8 个相邻的节点，又让你求最短距离，这不就是典型的 BFS 嘛，框架就可以派上用场了，先写出一个「简陋」的 BFS 框架代码再说别的：

// 1、会走回头路。比如说我们从 "0000" 拨到 "1000"，但是等从队列拿出 "1000" 时，还会拨出一个 "0000"，这样的话会产生死循环。
// 2、没有终止条件，按照题目要求，我们找到 target 就应该结束并返回拨动的次数。
// 3、没有对 deadends 的处理，按道理这些「死亡密码」是不能出现的，也就是说你遇到这些密码的时候需要跳过。


// https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/bfs-kuang-jia
// Q :https://www.lintcode.com/problem/open-the-lock/description
// https://www.jiuzhang.com/solution/open-the-lock/