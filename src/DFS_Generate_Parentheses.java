import java.util.ArrayList;
import java.util.List;

public class DFS_Generate_Parentheses {

    public static void main(String[] args) {
        DFS_Generate_Parentheses g = new DFS_Generate_Parentheses();
        List<String> result = g.generate(3);
        System.out.println(result);
    }

    List<String> result = new ArrayList<>();

    public List<String> generate (int n) {
        if (n == 0) {
            return result;
        }

        String track = "";
        helper(track, n , n);
        return result;
    }

    private void helper(String track, int left, int right) {
        // if not valid return
        if (left < 0 || right < 0 ) {
            return;
        }
        if (right < left) {
            return;
        }

        if (left == 0 && right == 0) { // end condition
            result.add(track);
            return;
        }

        track = track + "(";
        helper(track, left - 1, right);
        track = track.substring(0, track.length() - 1);

        track = track + ")";
        helper(track, left, right - 1);
        track = track.substring(0, track.length() - 1);

    }
}
