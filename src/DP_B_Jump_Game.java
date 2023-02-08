public class DP_B_Jump_Game {
}

// http://www.lintcode.com/problem/jump-game/
// http://www.jiuzhang.com/solutions/jump-game/


//最优算法:贪心法，时间复杂度 O(n) 次优算法:动态规划，时间复杂度 O(n^2)
 //       state: f[i]代表我能否跳到第i个位置 function: f[i] = OR(f[j], j < i && j能够跳到i) initialize: f[0] = true;
 //       answer: f[n-1]