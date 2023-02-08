import java.util.*;

public class DFS_K_sum_II {




    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return result;
        }

        List<Integer> combanition = new ArrayList<>();

        Arrays.sort(A);
        helper(combanition, 0, A, k, target);
        return result;
    }

    private void helper(List<Integer> combanition, int startIndex, int[] A, int k, int target) {

        // end condition
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(combanition));
            return;
        }

        if (k == 0) {
            return;
        }

        for (int i = startIndex; i < A.length; i++) {
            if (A[i] > target) {
                break;
            }
            combanition.add(A[i]);
            helper(combanition, i + 1, A, k - 1, target - A[i]);
            combanition.remove(combanition.size() - 1);
        }
    }
}

/***
 * Note :
 * next start index is i + 1, not startindex + 1;
 */