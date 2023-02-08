public class DP_D_Longest_Common_Sequence {
}

//http://www.lintcode.com/problem/longest-common-subsequence/
 //       http://www.jiuzhang.com/solutions/longest-common-subsequence/


//state: f[i][j]表示前i个字符配上前j个字符的LCS的长度
//        function: f[i][j] = MAX(f[i-1][j], f[i][j-1], f[i-1][j-1] + 1) // A[i - 1] == B[j - 1]
 //                           f[i-1][j-1] + 1 ---> A[i - 1] == B[j - 1] 算在LCS 里面
//                            f[i-1][j] ------> A[i - 1] 不在LCS 里面
//                            f[i][j - 1] -----> B[i - 1] 不在LCS 里面
//                            f[i -1][j - 1] ---> A[i -1] & B[i - 1] 都不在LCS 里面
//        = MAX(f[i-1][j], f[i][j-1])
//        intialize: f[i][0] = 0 f[0][j] = 0
//        answer: f[n][m] Related Question:
// A[i - 1] != B[j - 1]
//        为什么是i-1? A的第i个字符的是A[i-1]
//        http://www.lintcode.com/problem/longest-common-substring/