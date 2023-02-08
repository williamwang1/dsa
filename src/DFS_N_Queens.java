import java.util.ArrayList;
import java.util.List;

public class DFS_N_Queens {
    private static final int EMPTY = 0;
    private static final int QUEEN = 1;

    public static void main(String args[]) {
        DFS_N_Queens q = new DFS_N_Queens();
        q.solveNQueens(3);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList();
        if (n < 1) {
            return result;
        }
        int[][] board = new int[n][n];
        helper(0, board, result);
        return result;
    }

    private void helper(int row, int[][]board, List<List<String>> result) {
        int n = board.length;
        // return
        if (row == n) {
            resolveResults(board, result);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col, board)) {
                continue;
            }
            board[row][col] = QUEEN;
            helper(row + 1, board, result);
            board[row][col] = EMPTY;
        }
    }

    private void resolveResults(int[][]board, List<List<String>> result) {
        int n = board.length;
        List<String> element = new ArrayList();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == QUEEN) {
                    row.append('Q');
                } else {
                    row.append('.');
                }
            }
            element.add(row.toString());
        }
        result.add(element);
    }

    private boolean isValid(int row, int col, int[][] board) {
        // check column duplicate
        int n = board.length;
        for (int r = 0; r < n; r++) {
            if (board[r][col] == QUEEN) {
                return false;
            }

        }
        // 检查右上方是否有冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == QUEEN)
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == QUEEN)
                return false;
        }
        return true;
    }

}



// http://www.lintcode.com/problem/n-queens/
// http://www.jiuzhang.com/solutions/n-queens/


// use int[][]
//public class Solution {
//
//    private static final int EMPTY = 0;
//    private static final int QUEEN = 1;
//
//    /*
//     * @param n: The number of queens
//     * @return: All distinct solutions
//     */
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> solutions = new ArrayList<>();
//
//        if (n < 1) {
//            return solutions;
//        }
//
//        int[][] board = new int[n][n];
//
//        dfs(0, board, solutions);
//
//        return solutions;
//    }
//
//    private void dfs(int row,
//                     int[][] board,
//                     List<List<String>> solutions) {
//        int n = board.length;
//
//        if (row == n) {
//            // if row could be n, it means a queen must be placed at each row.
//            resolve(board, solutions);
//            return;
//        }
//
//        for (int col = 0; col < n; col++) {
//            if (!isValid(row, col, board)) {
//                continue;
//            }
//
//            // If no place in any col in current row,
//            //   will track back and will not exam next row.
//            board[row][col] = QUEEN;
//            dfs(row + 1, board, solutions);
//            board[row][col] = EMPTY;
//        }
//    }
//
//    private void resolve(int[][] board, List<List<String>> solutions) {
//        List<String> solution = new ArrayList<>();
//
//        int n = board.length;
//        for (int i = 0; i < n; i++) {
//            StringBuilder row = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                if (board[i][j] == QUEEN) {
//                    row.append('Q');
//                } else {
//                    row.append('.');
//                }
//            }
//            solution.add(row.toString());
//        }
//
//        solutions.add(solution);
//    }
//
//    private boolean isValid(int row, int col, int[][] board) {
//        int x = -1, y = -1;
//
//        int n = board.length;
//        for (int k = 0; k < n; k++) {
//            // same row
//            x = row;
//            y = k;
//            if (board[x][y] == QUEEN) {
//                return false;
//            }
//
//            // same col
//            x = k;
//            y = col;
//            if (board[x][y] == QUEEN) {
//                return false;
//            }
//
//            // same diagnal: x - row = y - col or x - row = -(y - col)
//            x = k;
//            y = x - row + col;  // x - row = y - col => y = x - row + col
//            if (0 <= y && y <= n - 1 && board[x][y] == QUEEN) {
//                return false;
//            }
//            y = row + col - x;  // x - row = -(y - col) => y = row + col - x
//            if (0 <= y && y <= n - 1 && board[x][y] == QUEEN) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}



//class Solution {
//    /**
//     * Get all distinct N-Queen solutions
//     * @param n: The number of queens
//     * @return: All distinct solutions
//     * For example, A string '...Q' shows a queen on forth position
//     */
//    List<List<String>> solveNQueens(int n) {
//        List<List<String>> results = new ArrayList<>();
//        if (n <= 0) {
//            return results;
//        }
//
//        search(results, new ArrayList<Integer>(), n);
//        return results;
//    }
//
//    /*
//     * results store all of the chessboards
//     * cols store the column indices for each row
//     */
//    private void search(List<List<String>> results,
//                        List<Integer> cols,
//                        int n) {
//        if (cols.size() == n) {
//            results.add(drawChessboard(cols));
//            return;
//        }
//
//        for (int colIndex = 0; colIndex < n; colIndex++) {
//            if (!isValid(cols, colIndex)) {
//                continue;
//            }
//            cols.add(colIndex);
//            search(results, cols, n);
//            cols.remove(cols.size() - 1);
//        }
//    }
//
//    private List<String> drawChessboard(List<Integer> cols) {
//        List<String> chessboard = new ArrayList<>();
//        for (int i = 0; i < cols.size(); i++) {
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < cols.size(); j++) {
//                sb.append(j == cols.get(i) ? 'Q' : '.');
//            }
//            chessboard.add(sb.toString());
//        }
//        return chessboard;
//    }
// // get currentColumn, selectedColumn, currentRow, selectedRow value
// //  List<Integer> cols, index is selectedRow, value is selectedCol
//private boolean isValid(List<Integer> cols, int currentCol) {
//    int currentRow = cols.size();
//    for (int selectedRow = 0; selectedRow < currentRow; selectedRow++) {
//        int selectedCol = cols.get(selectedRow);
//        if (selectedCol == currentCol) {
//            return false;
//        }
//        int colDiff = currentCol - selectedCol;
//        int rowDiff = currentRow - selectedRow;
//        if (colDiff == rowDiff) {
//            return false;
//        }
//        if (colDiff + rowDiff == 0) {
//            return false;
//        }
//    }
//    return true;
//}

//}
