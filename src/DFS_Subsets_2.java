import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_Subsets_2 {

    public static void main (String[] args) {
        DFS_Subsets_2 s = new DFS_Subsets_2();
        int[]nums = {1,2,2};
        List<List<Integer>> result = s.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null ) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList());
            return result;
        }
        ArrayList<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, subset , result);
        return result;
    }

    private void helper(int[]nums, int startIndex, ArrayList subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {

            if (i > startIndex && nums[i] == nums[i - 1] ) {
                System.out.println("i value " + i + " startIndex value " + startIndex);
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}

// https://www.lintcode.com/problem/subsets-ii/description

// 在有两个相邻的重复元素的情况下， 没有选第一个可选的，直接选后面的，把这种情况跳过
// if (i > startIndex && nums[i] == nums[i - 1] ) {
//        continue;
// }
// 上一个元素挑的事startIndex - 1， 当前元素是i， 由于 i > startIndex,
// 或者 i >= startIndex + 1 所以中间至少有一个startIndex 元素没有被选中