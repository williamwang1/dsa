public class TP_Partition_Array {
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // from left, stop at number which >= k
            while (left <= right && nums[left] < k) {
                left++;
            }

            while (left <= right && nums[right] >= k) {
                right--;
            }
            // when right > left, no need to swap
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }

        }
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

//Note:
 //       while end condition while (left <= right)
//        return left , coz left++ after swap, left is nums[first index] >= k
//        return right is wrong, coz right-- after swap, so right is nums[last index] < k

// http://www.lintcode.com/problem/partition-array/
 //       http://www.jiuzhang.com/solutions/partition-array/
