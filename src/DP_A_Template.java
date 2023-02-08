public class DP_A_Template {
}

// 矩阵 可以上下左右一起走， 是否可以用动态规划

// 如果有限制条件，防止无限转圈圈的发生，就可以用动态规划


// 只能记录最优的方案， 不能是所有方案
// 额外数组， 记录最优方案是由之前哪一个元素来的

// 坐标型动态规划 -- 下一个位置由上一个位置移动过来的，f(i)第 i位置 最长

    //state:
    //    f[x] 表示我从起点走到坐标x...... f[x][y] 表示我从起点走到坐标x,y......
    //        function: 研究走到x,y这个点之前的一步 intialize: 起点
    //        answer: 终点

// 单序列动态规划 n 个字符， 开n + 1 长度的数组  f[i]表示“前i”个字符

    //state: f[i]表示前i个位置/数字/字母,第i个... function: f[i] = f[j] ... j 是i之前的一个位置 initialize: f[0]..
    //        answer: f[n]..
    //        一般answer是f(n)而不是f(n-1)，因为对于n个字母，包含前0个字母(空串)，前1个字 母......前n个字母。
//        双序列动态规划
//      state: f[i][j]代表了第一个sequence的前i个数字/字符，配上第二个sequence 的前j个...
//      function: f[i][j] = 研究第i个和第j个的匹配关系
//        initialize: f[i][0] 和 f[0][i]
//        answer: f[n][m]
//        n = s1.length() m = s2.length()


// 区间型动态规划， 大区间依赖一个小区间
