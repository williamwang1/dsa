public class BS_Last_Position {

    public static void main(String[] argus) {
        int[] A = new int[]{1,2,2,4,5,5};
        BS_Last_Position a = new BS_Last_Position();
        int result = a.lastPosition(A, 2);
        System.out.println(result);
    }

    public int lastPosition(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 > end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
}

//二分法模板的四点要素
//    循环结束条件: 相邻就结束    start + 1 < end
//  终点取值:  start + (end - start) / 2
//   移动start end 指针 A[mid]  ==, <, >
//   A[start] A[end] ? target
//   两类二分，三个境界
    // 二分位置 Binary search on index • OOXX
    // Half half
    // 二分答案 Binary search on result
