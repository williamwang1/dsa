public class DP_S_Word_Break {
}


// http://www.lintcode.com/problem/word-break/
//        http://www.jiuzhang.com/solutions/word-break/


// 02:38:00
//state: f[i]表示“前i”个字符能否被完美切分
//        function: f[i] = OR{f[j] && j+1~i is a word}, 其中 j < i initialize: f[0] = true
 //       answer: f[n]
 //       注意:切分位置的枚举->单词长度枚举 O(NL2)
 //       ● N: 字符串长度
 //       ● L: 最长的单词的长度