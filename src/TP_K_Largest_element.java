public class TP_K_Largest_element {

    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // nth larget --> (nums.length - n + 1) smallest , index is nums.length -n
        return helper(nums, 0, nums.length - 1, nums.length - n);
    }

    // 在 nums[] [start, end] 区间找index = n 的元素
    private int helper(int[] nums, int start, int end, int n) {
        if (start == end) {
            return nums[n];
        }
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) /2];
        while (left <= right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (n <= right) {
            return helper(nums, start, right, n);
        } else {
            return helper(nums, left, end, n);
        }

    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
// steps :
//	1. partition array
//  2. n 与 left right 大小关系，决定在[start right] 或者[left, end] 区间继续partition
//  3. end condtion start == end, return nums[n]

// Note while end condition while(left <= right)

// 强化班 two sum 00:27:00

// partition first 看一下 partition border 是第几大
// 与k 比较，pivot 全局第几大，再从左边还是右边继续寻找
// O(n) --> (1 + n/2 + n/4 + n/8....)
// worst O(n2) largest 在左边