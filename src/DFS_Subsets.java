import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_Subsets {

    /**
     * @param : A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

    public static void main (String[] args) {
        DFS_Subsets s = new DFS_Subsets();
        int[]nums = {1,5,7,8};
        List<List<Integer>> result = s.subsets(nums);
        System.out.println(result);
    }


        public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }


    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        results.add(new ArrayList<Integer>(subset));

//        if (startIndex == nums.length) {
//            results.add(new ArrayList<Integer>(subset));
//            return;
//        }

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }



}


// end condition : start reach end of nums array, no elements in subsets

//public class DFS_Subsets {
//
//    /**
//     * @param : A set of numbers.
//     * @return: A list of lists. All valid subsets.
//     */
//
//    public static void main (String[] args) {
//        DFS_Subsets s = new DFS_Subsets();
//        int[]nums = {1,5,7,8};
//        List<List<Integer>> result = s.subsets(nums);
//        System.out.println(result);
//    }
//
//    List<List<Integer>> results = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//
//
//        if (nums == null) {
//            return results;
//        }
//
//        if (nums.length == 0) {
//            results.add(new ArrayList<Integer>());
//            return results;
//        }
//
//        Arrays.sort(nums);
//        helper(new ArrayList<Integer>(), nums, 0);
//        return results;
//    }
//
//
//    // 递归三要素
//    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
//    private void helper(ArrayList<Integer> subset,
//                        int[] nums, int startIndex) {
//        // 2. 递归的拆解
//        // deep copy
//        // results.add(subset);
//
//        for (int i = startIndex; i < nums[]; i++) {
//            // [1] -> [1,2]
//            subset.add(nums[i]);
//            // 寻找所有以 [1,2] 开头的集合，并扔到 results
//            helper(subset, nums, i + 1);
//            // [1,2] -> [1]  回溯
//            subset.remove(subset.size() - 1);
//        }
//
//        // 3. 递归的出口
//        // return;
//    }
//
//}


//public class DFS_Subsets {
//
//    /**
//     * @param : A set of numbers.
//     * @return: A list of lists. All valid subsets.
//     */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//
//        if (nums == null) {
//            return results;
//        }
//
//        if (nums.length == 0) {
//            results.add(new ArrayList<Integer>());
//            return results;
//        }
//
//        Arrays.sort(nums);
//        helper(new ArrayList<Integer>(), nums, 0, results);
//        return results;
//    }
//
//
//    // 递归三要素
//    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
//    private void helper(ArrayList<Integer> subset,
//                        int[] nums,
//                        int startIndex,
//                        List<List<Integer>> results) {
//        // 2. 递归的拆解
//        // deep copy
//        // results.add(subset);
//        results.add(new ArrayList<Integer>(subset));
//
//        for (int i = startIndex; i < nums.length; i++) {
//            // [1] -> [1,2]
//            subset.add(nums[i]);
//            // 寻找所有以 [1,2] 开头的集合，并扔到 results
//            helper(subset, nums, i + 1, results);
//            // [1,2] -> [1]  回溯
//            subset.remove(subset.size() - 1);
//        }
//
//        // 3. 递归的出口
//        // return;
//    }
//
//}


// Q http://www.lintcode.com/problem/subsets/
// A http://www.jiuzhang.com/solutions/subsets/
