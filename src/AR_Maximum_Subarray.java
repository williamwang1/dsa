public class AR_Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0, preMiniSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // get current sum
            sum = sum + nums[i];
            // get current max sum, update global max
            max = Math.max(max, sum - preMiniSum);
            // update glocal miniSum
            preMiniSum = Math.min(sum, preMiniSum);
        }

        return max;
    }
}

// sum[i...j] = prefix_sum[j] - prefix_sum[j - 1];

// http://www.lintcode.com/problem/maximum-subarray/



//给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
//
//    样例1:
//
//    输入：[−2,2,−3,4,−1,2,1,−5,3]
//    输出：6
//    解释：符合要求的子数组为[4,−1,2,1]，其最大和为 6。
//
//    样例2:
//
//    输入：[1,2,3,4]
//    输出：10
//    解释：符合要求的子数组为[1,2,3,4]，其最大和为 10。

// find sum for current position
// find previous minisum for current position
// update max with sum - previous mini sum



