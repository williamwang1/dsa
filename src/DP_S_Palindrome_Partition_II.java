public class DP_S_Palindrome_Partition_II {
}


// http://www.lintcode.com/problem/palindrome-partitioning-ii/
//http://www.jiuzhang.com/solutions/palindrome-partitioning-ii/


//state: f[i]前i个字符组成的子串能被分割为最少多少个回文串
// //function: f[i] = MIN{f[j]+1}, j < i && j+1 ~ i这一段是一个回文串
// initialize: f[i] = i (f[0] = 0)
 //       answer: f[n] - 1

// 区间型动态规划 初始化判断是否是回文串