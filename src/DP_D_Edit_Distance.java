public class DP_D_Edit_Distance {
}

//http://www.lintcode.com/problem/edit-distance/
//        http://www.jiuzhang.com/solutions/edit-distance/
//
//        state: f[i][j]表示A的前i个字符最少要用几次编辑可以变成B的前j个字符 function: f[i][j] = MIN(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]) // A[i - 1] == B[j - 1]
//        = MIN(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1) // A[i - 1] != B[j - 1] initialize: f[i][0] = i, f[0][j] = j
//        answer: f[n][m]


