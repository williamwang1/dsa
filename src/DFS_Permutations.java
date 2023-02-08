import java.util.*;

public class DFS_Permutations {

    // use external array to control visited or not
// visited boolen array, change to true after add, change to false after remove
// set integer, add to set after add, remove from set after remove

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList());
            return result;
        }
        Arrays.sort(nums);
        List<Integer> perm = new ArrayList();
        Set<Integer> set = new HashSet<>();
        helper(nums, perm, result, set);
        return result;
    }

    private void helper(int[] nums, List<Integer> perm, List<List<Integer>> result, Set<Integer> set) {
        // return condition
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            perm.add(nums[i]);
            set.add(nums[i]);
            helper(nums, perm, result, set);
            perm.remove(perm.size() - 1);
            set.remove(nums[i]);

        }
    }

}
// my way
// if temp set does not contain element, then add element into set

//http://www.lintcode.com/problem/permutations/
// http://www.jiuzhang.com/solutions/permutations/


//public class Solution {
//    /*
//     * @param nums: A list of integers.
//     * @return: A list of permutations.
//     */
//    public List<List<Integer>> permute(int[] nums) {
//        // write your code here
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums == null) {
//            return result;
//        }
//        if (nums.length == 0) {
//            result.add(new ArrayList());
//            return result;
//        }
//        Arrays.sort(nums);
//        List<Integer> perm = new ArrayList();
//        // Set<Integer> set = new HashSet<>();
//        // boolean[] visited = new boolean[nums.length];
//        //helper(nums, perm, result, visited);
//        helper(nums, perm, result);
//        return result;
//    }
//
//    // private void helper(int[] nums, List<Integer> perm, List<List<Integer>> result, Set<Integer> set) {
//
//    // private void helper(int[] nums, List<Integer> perm, List<List<Integer>> result, boolean[] visited) {
//    private void helper(int[] nums, List<Integer> perm, List<List<Integer>> result) {
//        // return condition
//        if (perm.size() == nums.length) {
//            result.add(new ArrayList<>(perm));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            // if (set.contains(nums[i])) {
//            //     continue;
//            // }
//            // if (visited[i]) {
//            //     continue;
//            // }
//            if (perm.contains(nums[i])) {
//                continue;
//            }
//            perm.add(nums[i]);
//            //set.add(nums[i]);
//            //visited[i] = true;
//            helper(nums, perm, result);
//            perm.remove(perm.size() - 1);
//            //set.remove(nums[i]);
//            //visited[i] = false;
//
//        }
//    }
//}



