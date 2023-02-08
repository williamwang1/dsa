public class DFS_Permutation_Non_Recusion {

}


//// Non-Recursion
//class Solution {
//    /**
//     * @param nums: A list of integers.
//     * @return: A list of permutations.
//     */
//    public List<List<Integer>> permute(int[] nums) {
//        ArrayList<List<Integer>> permutations
//                = new ArrayLi st<List<Integer>>();
//        if (nums == null) {
//
//            return permutations;
//        }
//
//        if (nums.length == 0) {
//            permutations.add(new ArrayList<Integer>());
//            return permutations;
//        }
//
//        int n = nums.length;
//        ArrayList<Integer> stack = new ArrayList<Integer>();
//
//        stack.add(-1); /// why put -1 inside ?
//        while (stack.size() != 0) {
//            Integer last = stack.get(stack.size() - 1);
//            stack.remove(stack.size() - 1);
//
//            // increase the last number
//            int next = -1;
//            for (int i = last + 1; i < n; i++) {
//                if (!stack.contains(i)) {
//                    next = i;
//                    break;
//                }
//            }
//            if (next == -1) {
//                continue;
//            }
//
//            // generate the next permutation
//            stack.add(next);
//            for (int i = 0; i < n; i++) {
//                if (!stack.contains(i)) {
//                    stack.add(i);
//                }
//            }
//
//            // copy to permutations set
//            ArrayList<Integer> permutation = new ArrayList<Integer>();
//            for (int i = 0; i < n; i++) {
//                permutation.add(nums[stack.get(i)]);
//            }
//            permutations.add(permutation);
//        }
//
//        return permutations;
//    }
//}
