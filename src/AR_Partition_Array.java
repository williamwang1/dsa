public class AR_Partition_Array {

    public static void main(String[] argus) {
        AR_Partition_Array pa = new AR_Partition_Array();
        int[] nums = new int[]{3,2,1};
        int k = 2;
        pa.partitionArray(nums, k);

    }

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

/**
 * steps
 *
 * 1. find left not meet with condition
 * 2. find right not meet with condition
 * 3. swap both, move forward left, backward right (only when left ,= right)
 * 4. repeat 1 till left > right
 */



