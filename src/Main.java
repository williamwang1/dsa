import java.util.List;

public class Main {

    public static void main (String[] args) {
        DFS_Subsets s = new DFS_Subsets();
        int[]nums = {1,5,7,8};
        List<List<Integer>> result = s.subsets(nums);
    }
}
