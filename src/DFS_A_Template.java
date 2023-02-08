public class DFS_A_Template {

    // 回溯模板

//    result = []
//    def backtrack(路径, 选择列表, 结束条件):
//            (路径剪枝)
//            if 满足结束条件:
//            result.add(路径)
//            return
//
//            for 选择 in 选择列表:
    //              (选择列表剪枝)
//                  做选择
//                  backtrack(路径, 选择列表)
//                  撤销选择
}

// 适合 找出所有方案  类型的题

// 如果只是找点， 不是找路径，就不需要回溯 ，例如 Number of islands

// 通用的DFS时间复杂度计算公式 O(答案个数 * 构造每个答案的时间)

/**
 * Combination
 * http://www.jiuzhang.com/solutions/subsets/
 * Permutation
 * http://www.jiuzhang.com/solutions/permutations/
 *
 * Combination Sum
 * http://www.lintcode.com/problem/combination-sum/
 * http://www.jiuzhang.com/solutions/combination-sum/
 *
 *  Combination Sum II
 * http://www.lintcode.com/problem/combination-sum-ii/
 * http://www.jiuzhang.com/solutions/combination-sum-ii/
 *
 * String Permutation II
 * www.lintcode.com/problem/string-permutation-ii
 * www.jiuzhang.com/solutions/string-permutation-ii
 *
 * k Sum II
 * http://www.lintcode.com/problem/k-sum-ii/  -- 0.5
 * http://www.jiuzhang.com/solution/k-sum-ii/
 *
 * N Queens
 * http://www.lintcode.com/problem/n-queens/
 * http://www.jiuzhang.com/solutions/n-queens/
 * 另一种问法:问方案总数(N Queens II)
 *
 * 下一个排列
 * http://www.lintcode.com/problem/next-permutation/ -- 0.5
 * http://www.lintcode.com/problem/next-permutation-ii/
 *
 * 排列的顺序
 * http://www.lintcode.com/problem/permutation-index/ -- 0
 * http://www.lintcode.com/problem/permutation-index-ii/
 *
 * Letter Combinations of Phone Number -- 1
 * http://www.lintcode.com/problem/letter-combinations-of-a-phone-number/
 * http://www.jiuzhang.com/solution/letter-combinations-of-a-phone-number/
 * 什么是点?什么是边?什么是路径?
 * Follow up
 * 如果有一个词典(Dictionary) 要求组成的单词都是词典里的 如何优化?
 *
 * Word Search II -- 0.5
 * http://www.lintcode.com/problem/word-search-ii/
 * http://www.jiuzhang.com/solution/word-search-ii/
 * 矩阵(Matrix)也是图
 *
 * Word Ladder II -- 1.5
 * http://www.lintcode.com/problem/word-ladder-ii/
 * http://www.jiuzhang.com/solutions/word-ladder-ii/
 * 求所有的最短路径
 *
 *  Palindrome Partitioning - 0.5
 *  Palindrome Partitioning follow up - 0.5
 * http://www.lintcode.com/problem/palindrome-partitioning/
 * http://www.jiuzhang.com/solutions/palindrome-partitioning/
 * 问:有什么可以优化的地方?
 *
 * */