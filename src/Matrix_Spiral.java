import java.util.ArrayList;
import java.util.List;

public class Matrix_Spiral {



    public List<Integer> spiralOrder(int[][] matrix) {
        List result = new ArrayList();
        if (matrix.length == 0) return result;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] seen = new boolean[row][column];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i =0; i < row * column; i++) {
            // add element in result list
            result.add(matrix[r][c]);
            seen[r][c] = true;
            // next row/column if no change in direction
            int nr = r + dr[di];
            int nc = c + dc[di];
            // condition not to change direction
            // with row length, within column length
            // not tranversed before
            if (nr >= 0 && nr < row && nc >=0 && nc < column && !seen[nr][nc] ) {
                r = nr;
                c = nc;
            } else {
                // direction change from 0->1->2->3->0->1
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }

        }
        return result;
    }
}

