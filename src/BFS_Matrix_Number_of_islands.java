import java.util.LinkedList;
import java.util.Queue;




public class BFS_Matrix_Number_of_islands {

    class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(boolean[][] grid) {
        int result = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] v = new boolean[row][column];

        int[] dx = {0, 1, 0 ,1};
        int[] dy = {1, 0, -1, 0};

        Queue<Coordinate> queue = new LinkedList<>();


        // initialize all visited false
        // put all true elements into queue
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                v[i][j] = false;
                if (grid[i][j]) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate head = queue.poll();
            // skip visited true element
            if (v[head.x][head.y]) {
                continue;
            }
            // BFS all true elements near head
            Queue<Coordinate> level = new LinkedList<>();
            level.offer(head);
            while (!level.isEmpty()) {
                Coordinate cur = level.poll();
                for (int direction = 0; direction < 4; direction ++) {
                    int nr = cur.x + dx[direction];
                    int nc = cur.y + dy[direction];
                    if (!inBound(nr, nc, row, column)) {
                        continue;
                    }
                    if (v[nr][nc]) {
                        continue;
                    }
                    if (grid[nr][nc]) {
                        v[nr][nc] = true;
                        level.offer(new Coordinate(nr, nc));
                    }
                }
            }

            result ++;
        }
        return result;
    }

    private boolean inBound(int nr, int nc, int row, int column) {
        boolean result = false;
        if (0 <= nr && nr < row && 0 <= nc && nc < column) {
            return true;
        }
        return result;

    }

//    public int numIslands(boolean[][] grid) {
//        // write your code here
//        int result = 0;
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return result;
//        }
//
//        int row = grid.length;
//        int column = grid[0].length;
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                if (grid[i][j]) {
//                  // mark surrounded true as false
//                    markByBFS(grid, i, j, row, column);
//                    result++;
//                }
//            }
//        }
//
//        return result;
//    }

    private void markByBFS(boolean[][] grid, int i, int j, int row, int column) {
        Queue<Coordinate> queue = new LinkedList<>();
        int[] dx = {0, 1, -1 ,0};
        int[] dy = {1, 0, 0, -1};
        queue.offer(new Coordinate(i, j));
        grid[i][j] = false;
        while(!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            // put all surrounded true inside queue
            for(int direction = 0; direction < 4; direction++) {
                int nx = cur.x + dx[direction];
                int ny = cur.y + dy[direction];
                //
                if (!inBound(nx, ny, row, column)) {
                    continue;
                }
                if (grid[nx][ny]) {
                    queue.offer(new Coordinate(nx, ny));
                    grid[nx][ny] = false;
                }

            }
        }
    }
}


//  Q https://www.lintcode.com/problem/number-of-islands/description
//  A https://www.jiuzhang.com/solutions/number-of-islands/
//
//    Description

//        Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
//
//        Find the number of islands.



//Example
//        Example 1:
//
//        Input:
//        [
//        [1,1,0,0,0],
//        [0,1,0,0,1],
//        [0,0,0,1,1],
//        [0,0,0,0,0],
//        [0,0,0,0,1]
//        ]
//        Output:
//        3
//        Example 2:
//
//        Input:
//        [
//        [1,1]
//        ]
//        Output:
//        1



//// version 1: BFS
//class Coordinate {
//    int x, y;
//    public Coordinate(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Solution {
//    /**
//     * @param grid a boolean 2D matrix
//     * @return an integer
//     */
//    public int numIslands(boolean[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//
//        int n = grid.length;
//        int m = grid[0].length;
//        int islands = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j]) {
//                    markByBFS(grid, i, j);
//                    islands++;
//                }
//            }
//        }
//
//        return islands;
//    }
//
//    private void markByBFS(boolean[][] grid, int x, int y) {
//        // magic numbers!
//        int[] directionX = {0, 1, -1, 0};
//        int[] directionY = {1, 0, 0, -1};
//
//        Queue<Coordinate> queue = new LinkedList<>();
//
//        queue.offer(new Coordinate(x, y));
//        grid[x][y] = false;
//
//        while (!queue.isEmpty()) {
//            Coordinate coor = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                Coordinate adj = new Coordinate(
//                        coor.x + directionX[i],
//                        coor.y + directionY[i]
//                );
//                if (!inBound(adj, grid)) {
//                    continue;
//                }
//                if (grid[adj.x][adj.y]) {
//                    grid[adj.x][adj.y] = false;
//                    queue.offer(adj);
//                }
//            }
//        }
//    }
//
//    private boolean inBound(Coordinate coor, boolean[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//
//        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
//    }
//}
//
//// version 2: Union Find
//class UnionFind {
//
//    private int[] father = null;
//    private int count;
//
//    private int find(int x) {
//        if (father[x] == x) {
//            return x;
//        }
//        return father[x] = find(father[x]);
//    }
//
//    public UnionFind(int n) {
//        // initialize your data structure here.
//        father = new int[n];
//        for (int i = 0; i < n; ++i) {
//            father[i] = i;
//        }
//    }
//
//    public void connect(int a, int b) {
//        // Write your code here
//        int root_a = find(a);
//        int root_b = find(b);
//        if (root_a != root_b) {
//            father[root_a] = root_b;
//            count --;
//        }
//    }
//
//    public int query() {
//        // Write your code here
//        return count;
//    }
//
//    public void set_count(int total) {
//        count = total;
//    }
//}
//
//public class Solution {
//    /**
//     * @param grid a boolean 2D matrix
//     * @return an integer
//     */
//    public int numIslands(boolean[][] grid) {
//        int count = 0;
//        int n = grid.length;
//        if (n == 0)
//            return 0;
//        int m = grid[0].length;
//        if (m == 0)
//            return 0;
//        UnionFind union_find = new UnionFind(n * m);
//
//        int total = 0;
//        for(int i = 0;i < grid.length; ++i)
//            for(int j = 0;j < grid[0].length; ++j)
//                if (grid[i][j])
//                    total ++;
//
//        union_find.set_count(total);
//        for(int i = 0;i < grid.length; ++i)
//            for(int j = 0;j < grid[0].length; ++j)
//                if (grid[i][j]) {
//                    if (i > 0 && grid[i - 1][j]) {
//                        union_find.connect(i * m + j, (i - 1) * m + j);
//                    }
//                    if (i <  n - 1 && grid[i + 1][j]) {
//                        union_find.connect(i * m + j, (i + 1) * m + j);
//                    }
//                    if (j > 0 && grid[i][j - 1]) {
//                        union_find.connect(i * m + j, i * m + j - 1);
//                    }
//                    if (j < m - 1 && grid[i][j + 1]) {
//                        union_find.connect(i * m + j, i * m + j + 1);
//                    }
//                }
//        return union_find.query();
//    }
//}
//
//// version 3: DFS (not recommended)
//public class Solution {
//    /**
//     * @param grid a boolean 2D matrix
//     * @return an integer
//     */
//    private int m, n;
//    public void dfs(boolean[][] grid, int i, int j) {
//        if (i < 0 || i >= m || j < 0 || j >= n) return;
//
//        if (grid[i][j]) {
//            grid[i][j] = false;
//            dfs(grid, i - 1, j);
//            dfs(grid, i + 1, j);
//            dfs(grid, i, j - 1);
//            dfs(grid, i, j + 1);
//        }
//    }
//
//    public int numIslands(boolean[][] grid) {
//        // Write your code here
//        m = grid.length;
//        if (m == 0) return 0;
//        n = grid[0].length;
//        if (n == 0) return 0;
//
//        int ans = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!grid[i][j]) continue;
//                ans++;
//                dfs(grid, i, j);
//            }
//        }
//        return ans;
//    }
//}
//
//
////version 硅谷算法班
//public class Solution {
//    /**
//     * @param grid: a boolean 2D matrix
//     * @return: an integer
//     */
//    public int numIslands(boolean[][] grid) {
//        // write your code here
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int ans = 0;
//        boolean[][] v = new boolean[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] && !v[i][j]) {
//                    ans++;
//                    bfs(grid, v, i, j);
//                }
//            }
//        }
//        return ans;
//    }
//
//    private void bfs(boolean[][] grid, boolean[][] v, int sx, int sy) {
//        int[] dx = {1, 0, 0, -1};
//        int[] dy = {0, 1, -1, 0};
//
//        Queue<Integer> qx = new LinkedList<>();
//        Queue<Integer> qy = new LinkedList<>();
//
//        qx.offer(sx);
//        qy.offer(sy);
//        v[sx][sy] = true;
//
//        while (!qx.isEmpty()) {
//            int cx = qx.poll();
//            int cy = qy.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int nx = cx + dx[i];
//                int ny = cy + dy[i];
//                if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && !v[nx][ny] && grid[nx][ny]) {
//                    qx.offer(nx);
//                    qy.offer(ny);
//                    v[nx][ny] = true;
//                }
//            }
//        }
//    }
//}
