import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Matrix_Surrounded_region {

    class Element {
        int x, y;
        char c;
        public Element(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        BFS_Matrix_Surrounded_region r = new BFS_Matrix_Surrounded_region();
        char[][] board = new char[][] {
                {'X', 'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X', 'X'}, {'X', 'X', 'O', 'O', 'X'},{'X','X','O', 'X', 'X'}, {'X','X','O', 'X', 'X'}
        };
        r.surroundedRegions(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(board[i][j]);
            }
        }

    }


    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board == null) {
            return;
        }
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[row][column];
        // get all 'O' elements
        Queue<Element> initialElements = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                visited[i][j] = false;
                if (board[i][j] == 'O') {
                    initialElements.add(new Element(i, j, board[i][j]));
                }
            }
        }
        List<List<Element>> tempResult = new ArrayList();
        // Start from each 'O' get surrounded 'O', skip visited
        while(!initialElements.isEmpty()) {
            Element head = initialElements.poll();
            if (visited[head.x][head.y] == true) {
                continue;
            }
            // get surrounded 'O' in the region
            Queue<Element> level = new LinkedList<>();
            List<Element> elements = new ArrayList<>();
            level.offer(head);

            while (!level.isEmpty()) {
                Element cur = level.poll();
                elements.add(cur);

                // add into level results

                for (int i = 0; i < 4; i++) {
                    int nr = cur.x + dx[i];
                    int nc = cur.y + dy[i];
                    if (!inBound(nr, nc, row, column)) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    if (board[nr][nc] == 'O') {
                        level.offer(new Element(nr, nc , board[nr][nc]));
                    }
                    visited[nr][nc] = true;

                }
                visited[cur.x][cur.y] = true;
            }
            tempResult.add(elements);
        }


        for (List<Element> elements : tempResult) {
            if (elements.size() > 0 ) {
                boolean boudary = false;
                for (Element e : elements) {
                    if (e.x == row - 1 || e.y == column - 1 || e.x == 0 || e.y == 0) {
                        boudary = true;
                    }
                }
                if (!boudary) {
                    for (Element e : elements) {
                        board[e.x][e.y] = 'X';
                    }
                }


            }

        }
    }

    private boolean inBound(int nr, int nc, int row, int column) {
        boolean result = false;
        if (0 <= nr && nr < row && 0 <= nc && nc < column) {
            return true;
        }
        return result;
    }
}
