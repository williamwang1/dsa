import java.util.*;

public class DFS_Word_Search_II {
    /**
     * A word can start from any position in the matrix -- DFS 起点
     * go left/right/up/down to the adjacent position. -- next selection list
     * One character only be used once in one word -- can not go back
     *
     * Q : why is not necessary for backtrack word ?
     * no need to go back
     *
     * Q : why after add into result, no return ?
     *
     * validate input
     * two dimension array, validate row, column
     *
     * Steps:
     * 1. loop matrix 选起点
     * 2. 起点vistied，
     * 3. search 周边，
     * 4. revert 起点not visited
     *
     * search - dfs 模板
     * 1. 剪枝, map 里不存在word
     * 2. 如果是最终的word 加到result 不需要return
     * 3. 只backtrack visited， 不需要backtrack word
     *
     * */

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    int row;
    int col;
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        Set<String> result = new HashSet<>();
        if (board == null || board.length == 0) {
            return new ArrayList<>(result);
        }
        if (board[0] == null || board[0].length == 0) {
            return new ArrayList<>(result);
        }

        row = board.length;
        col = board[0].length;

        boolean[][] visited = new boolean[row][col];
        Map<String, Boolean> prefixIsWord = getPrefix(words);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // no go back after going forward
                visited[i][j] = true;
                search(board, i, j, visited, String.valueOf(board[i][j]), prefixIsWord, result);
                // after tranvere all points with the start board[i][j], board[i][j] can still be used // as adjacent points at the start of other points.
                visited[i][j] = false;
            }
        }


        return new ArrayList<>(result);
    }

    private void search(char[][]board,
                        int i, int j,
                        boolean[][] visited,
                        String word,
                        Map<String, Boolean> prefixIsWord,
                        Set<String> result) {
        // if word is not in map, no need to try surrounding character
        if (!prefixIsWord.containsKey(word)) {
            return;
        }

        // why no return ?
        if (prefixIsWord.get(word)) {
            result.add(word);
        }


        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (!isValid(nx, ny, visited)) {
                continue;
            }

            visited[nx][ny] = true;
            // why not backtrack word ??
            search(board, nx, ny, visited, word + board[nx][ny], prefixIsWord, result);
            visited[nx][ny] = false;
        }
    }

    private boolean isValid(int nx, int ny, boolean[][] visited) {
        boolean xvalid = nx >= 0 && nx < row;
        boolean yvalid = ny >= 0 && ny < col;
        return xvalid && yvalid && !visited[nx][ny];
    }

    private Map<String, Boolean> getPrefix(List<String> words) {
        Map<String, Boolean> result = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String prefix =word.substring(0, i + 1);
                if (!result.containsKey(prefix)) {
                    result.put(prefix, false);
                }
            }
            result.put(word, true);
        }
        return result;
    }
}


