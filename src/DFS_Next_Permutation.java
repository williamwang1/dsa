public class DFS_Next_Permutation {

    public static void main(String[] argus) {
        DFS_Next_Permutation np = new DFS_Next_Permutation();
        int[] nums = new int[]{1,3,2};
        np.nextPermutation(nums);
    }

//    public void reverse(int[] num, int start, int end) {
//        for (int i = start, j = end; i < j; i++, j--) {
//            int temp = num[i];
//            num[i] = num[j];
//            num[j] = temp;
//        }
//    }
//
//    public int[] nextPermutation(int[] num) {
//        // find the last increase index
//        int index = -1;
//        for (int i = num.length - 2; i >= 0; i--) {
//            if (num[i] < num[i + 1]) {
//                index = i;
//                break;
//            }
//        }
//        if (index == -1) {
//            reverse(num, 0, num.length - 1);
//            return num;
//        }
//
//        // find the first bigger one
//        int biggerIndex = index + 1;
//        for (int i = num.length - 1; i > index; i--) {
//            if (num[i] > num[index]) {
//                biggerIndex = i;
//                break;
//            }
//        }
//
//        // swap them to make the permutation bigger
//        int temp = num[index];
//        num[index] = num[biggerIndex];
//        num[biggerIndex] = temp;
//
//        // reverse the last part
//        reverse(num, index + 1, num.length - 1);
//        return num;
//    }

    public int[] nextPermutation(int[] nums) {
        // write your code here
        int length = nums.length;

        int index = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            swapList(nums, 0, length - 1);
            return nums;
        }
        int j = index + 1;
        while (j < length) {
            if (nums[j] > nums[index]) {
                swapItem(nums, j, index);
                break;
            }
            j++;
        }

        swapList(nums, index + 1, length - 1);
        return nums;
    }

    private void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }
}


