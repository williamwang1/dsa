public class TP_A_Questions {
/** Two Pointers
 * 背向双指针
 * 第一节课中的 Longest Palindromic Substring 的中心线枚举算法
 * 第二节课中的 Find K Closest Elements
 * 相向双指针
 * Reverse 类
 * 上节课随课教程中的三步翻转法就是这一类
 * Valid Palindrome
 * 验证一个字符串是否为回文串，忽略大小写和非英文字母字符
 * http://www.lintcode.com/problem/valid-palindrome/
            * http://www.jiuzhang.com/solution/valid-palindrome/
            *
            * Follow up: 可以删掉一个字符
 * http://www.lintcode.com/problem/valid-palindrome-ii/
            * https://www.jiuzhang.com/solution/valid-palindrome-ii/
            * 其实是一道证明题，证明见随课教程：
            * http://www.jiuzhang.com/tutorial/algorithm/390
            *
            * Two Sum 的一大类题（两位数的相关变形题）
            * 只能使用 HashMap：
            * http://www.lintcode.com/problem/two-sum-data-structure-design/
            * http://www.jiuzhang.com/solutions/two-sum-data-structure-design/
            * 使用 Two Pointers 会更快：
            * http://www.lintcode.com/problem/two-sum-input-array-is-sorted/
            * http://www.jiuzhang.com/solutions/two-sum-input-array-is-sorted/
            *
            * Two Sum - Unique pairs
 * https://www.lintcode.com/problem/two-sum-unique-pairs/
            * https://www.jiuzhang.com/solutions/two-sum-unique-pairs/
            * 问：是否可以先去重？
            *
            * 3Sum
 * https://www.lintcode.com/problem/3sum/
            * https://www.jiuzhang.com/solutions/3sum/
            * 统计所有的和为 0 的三元组 (Triples)
 *
         * Triangle Count
 * https://www.lintcode.com/problem/triangle-count/
            * https://www.jiuzhang.com/solutions/triangle-count/
            *
            * 统计所有和 <= target 的配对数
 * http://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target/
            * http://www.jiuzhang.com/solutions/two-sum-less-than-or-equal-to-target/
            * 统计所有和 >= target 的配对数
 * http://www.lintcode.com/en/problem/two-sum-greater-than-target/
            * http://www.jiuzhang.com/solutions/two-sum-greater-than-target/
            *
            * Two Sum - Closest to Target
 * https://www.lintcode.com/problem/two-sum-closest-to-target/
            * https://www.jiuzhang.com/solutions/two-sum-closest-to-target/
            *
            * Follow Up: 3Sum Closest
 * http://www.lintcode.com/problem/3sum-closest/
            * http://www.jiuzhang.com/solutions/3sum-closest/
            *
            * • 4Sum
 * • http://www.lintcode.com/problem/4sum/
            * • http://www.jiuzhang.com/solutions/4sum/
            * • Two Sum - difference equals to target (同向双指针，讲解见随课教程)
 * • http://www.lintcode.com/problem/two-sum-difference-equals-to-target/
            * • http://www.jiuzhang.com/solutions/two-sum-difference-equals-to-target/
            *
            * Partition 的一大类题（两位数相关变形题）
            *
            * Partition Array
 * https://www.lintcode.com/problem/partition-array/
            * https://www.jiuzhang.com/solutions/partition-array/
            * 时间复杂度与最内层循环主体的执行次数有关  与有多少重循环无关
 *
         * Quick Select
 * 随课教程：http://www.jiuzhang.com/tutorial/algorithm/321
            * http://www.lintcode.com/problem/kth-smallest-numbers-in-unsorted-array/
            * http://www.lintcode.com/problem/kth-largest-element/
            *
            * Partition Array by Odd and Even
 * http://www.lintcode.com/problem/partition-array-by-odd-and-even/
            * http://www.jiuzhang.com/solutions/partition-array-by-odd-and-even/
            *
            * Interleaving Positive and Negative Numbers
 * http://www.lintcode.com/problem/interleaving-positive-and-negative-numbers/
            * http://www.jiuzhang.com/solutions/interleaving-positive-and-negative-integers/
            *
            * Sort Letters by Case
 * http://www.lintcode.com/problem/sort-letters-by-case/
            * http://www.jiuzhang.com/solutions/sort-letters-by-case/
            *
            * Sort Colors
 * http://www.lintcode.com/problem/sort-colors/
            * http://www.jiuzhang.com/solutions/sort-colors/
            * 分成两个部分 vs 分成三个部分
 * 随课教程 http://www.jiuzhang.com/tutorial/algorithm/354
            *
            * 排序 Rainbow Sort
 * https://www.lintcode.com/problem/sort-colors-ii/
            * https://www.jiuzhang.com/solutions/sort-colors-ii/
            * 问：猜一猜最优的时间复杂度？
            *
            * 烙饼排序 Pancake Sort（有可能会考哦）
            * https://en.wikipedia.org/wiki/Pancake_sorting
            * http://www.geeksforgeeks.org/pancake-sorting/
            * 睡眠排序 Sleep Sort
 * https://rosettacode.org/wiki/Sorting_algorithms/Sleep_sort
            * 面条排序 Spaghetti Sort
 * https://en.wikipedia.org/wiki/Spaghetti_sort
            * 猴子排序 Bogo Sort
 * https://en.wikipedia.org/wiki/Bogosort
            *
            * 同向双指针
 * 滑动窗口类 Sliding Window
 *  * http://www.lintcode.com/problem/window-sum/
            * 76.最小覆盖子串（困难）
            * https://leetcode-cn.com/problems/minimum-window-substring/
            * 567.字符串的排列（中等）
            * https://leetcode-cn.com/problems/permutation-in-string/
            * 438.找到字符串中所有字母异位词（中等）
            * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
            * 3.无重复字符的最长子串（中等）
            * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
            * 快慢指针类 Fast & Slow Pointers
 * http://www.lintcode.com/problem/linked-list-cycle/
            * http://www.lintcode.com/problem/linked-list-cycle-ii/
            *
            * http://www.lintcode.com/problem/remove-duplicate-numbers-in-array/
            * http://www.lintcode.com/problem/intersection-of-two-linked-lists/
            * http://www.lintcode.com/problem/intersection-of-two-linked-lists/
            */
}
