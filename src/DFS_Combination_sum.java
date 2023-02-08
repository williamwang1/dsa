import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_Combination_sum {

    public static void main(String[] args) {
        DFS_Combination_sum g = new DFS_Combination_sum();
        int[] a = {1,2,3};
        List<List<Integer>> result = g.combinationSum(a, 4);
        System.out.println(result);
    }

//    List<List<Integer>> result = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum (int[] nums, int target) {
//        if (nums.length == 0) {
//            return result;
//        }
//        helper(nums, 0, target, new ArrayList<>());
//
//        return result;
//    }
//    // 递归定义
//    private void helper(int[] nums, int index,  int target, List<Integer> track) {
//        // end condition
//        if (target == 0) {
//            result.add(new ArrayList<>(track));
//            return;
//        }
//        // loop selection
//        for (int i = index; i < nums.length; i++) {
//
//            if (nums[i] > target) {      // sum of elements > target,
//                break;
//            }
//
//            if (i != index && nums[i] == nums[i - 1]) {  // skip duplicate
//                continue;
//            }
//            track.add(nums[i]);
//            helper(nums, i, target - nums[i], track);
//            track.remove(track.size() - 1);
//        }
//    }

    // version 2
    // remove duplicates first
    public List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[]nums= removeDuplicates(candidates);
        helper(nums, 0, new ArrayList<Integer>(), target, result);
        return result;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }

    // 递归定义
    //
    private void helper(int[]nums, int startIndex, ArrayList<Integer> combination, int target, List<List<Integer>> result) {

        // end condition
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {

            // nums[i] 后面的元素全部不需要循环，所以break
            if (nums[i] > target) {
                break;
            }
            combination.add(nums[i]);
            helper(nums, i, combination, target - nums[i], result);
            combination.remove(combination.size() - 1);
        }
    }

}
