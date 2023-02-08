public class BS_A_Any_Postion_Template {

    public static void main(String[] argus) {
        int[] A = new int[]{1,4,7,9,12,13};
        BS_A_Any_Postion_Template a = new BS_A_Any_Postion_Template();
        int result = a.search(A, 9);
        System.out.println(result);
    }

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return  -1;
        }
        int start = 0;
        int end = A.length -1;
        while( start + 1 < end) {
            int mid = start + (end - start) /2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            return  start;
        }
        if (A[end] == target) {
            return end;
        }
        return  -1;
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

 //第一境界
 //        二分位置 之 OOXX 一般会给你一个数组
 //        让你找数组中第一个/最后一个满足某个条件的位置 OOOOOOO...OOXX....XXXXXX

   // 第二境界 二分位置 之 Half half
   //     并无法找到一个条件，形成 OOXX 的模型 但可以根据判断，保留下有解的那一半或者去掉无解的一半

// 第三境界:二分答案
//         Binary Search on Result
 //        往往没有给你一个数组让你二分 而且题目压根看不出来是个二分法可以做的题
 //        同样是找到满足某个条件的最大或者最小值

// 最总要求的东西作为target， 根据题意确定start 和 end


//    Search a 2D Matrix
//        http://www.lintcode.com/en/problem/search-a-2d-matrix/
//        http://www.lintcode.com/en/problem/search-a-2d-matrix-ii/
//        不是二分法，但是是常考题
//    Search for a Range
//        http://www.lintcode.com/en/problem/search-for-a-range/
//        http://www.lintcode.com/en/problem/total-occurrence-of-target/
//
//    Maximum Number in Mountain Sequence
//        http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/

//    Search in a 2D Matrix II
//        小视频:http://www.jiuzhang.com/video/28/?session_id=7 • 不是二分法，但是是常考题
//     Binary Search:
//        • http://www.lintcode.com/problem/search-insert-position/
//        • http://www.lintcode.com/problem/count-of-smaller-number/
//        • http://www.lintcode.com/problem/search-for-a-range/
//     Rotate Array
//        • 小视频:http://www.jiuzhang.com/video/29/?session_id=7
//        • http://www.lintcode.com/problem/recover-rotated-sorted-array/ • http://www.lintcode.com/problem/rotate-string/
//        • 三步翻转法:
//        • [4,5,1,2,3] → [5,4,1,2,3] → [5,4,3,2,1] → [1,2,3,4,5]

// Recover Rotated Sorted Array
//  http://www.lintcode.com/problem/recover-rotated-sorted-array/
//  http://www.jiuzhang.com/solutions/recover-rotated-sorted-array/
// Rotate String
    //http://www.lintcode.com/problem/rotate-string/
    // http://www.jiuzhang.com/solutions/rotate-string/

//    Count of Smaller Number:
// http://www.lintcode.com/problem/count-of-smaller-number/
// Search for a Range / Number of Target
// http://www.lintcode.com/problem/search-for-a-range/
// Search in a Big/Infinite Sorted Array
// http://www.lintcode.com/problem/search-in-a-big-sorted-array/