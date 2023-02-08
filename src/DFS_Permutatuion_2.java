public class DFS_Permutatuion_2 {
}


// my way i 元素与 i - 1 相同， 并且 i-1 元素没有在集合里面


// http://www.lintcode.com/problem/permutations-ii/
// http://www.jiuzhang.com/solutions/permutations-ii/


// Wrong answer !!!!!
//public class Solution {
//    /*
//     * @param :  A list of integers
//     * @return: A list of unique permutations
//     */
//      public List<List<Integer>> permuteUnique(int[] nums) {
//        // write your code here
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
//        Set<Integer> set = new HashSet<>();
//        helper(nums, perm, result, set);
//        return result;
//    }
//
//    private void helper(int[] nums, List<Integer> perm, List<List<Integer>> result, Set<Integer> set) {
//        // return condition
//        if (perm.size() == nums.length) {
//            result.add(new ArrayList<>(perm));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                continue;
//            }
//            if (i > 0 &&  nums[i] == nums[i -1]&& !set.contains(nums[i - 1])) {
//                continue;
//            }
//            perm.add(nums[i]);
//            set.add(nums[i]);
//            helper(nums, perm, result, set);
//            perm.remove(perm.size() - 1);
//            set.remove(nums[i]);
//
//        }
//    }
//};