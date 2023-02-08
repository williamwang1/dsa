public class AR_Median_Two_Sorted_Array {
}

// http://www.lintcode.com/problem/median-of-two-sorted-arrays/
//http://www.jiuzhang.com/solutions/median-of-two-sorted-arrays/

// brute force
// merge into one
// Time Complexity O(m + n)


// follow up
//O(log(m +n)/2)
// --find Kth largest
// O(1) time --> O(k) --> O (k/2) O(1)时间变换在更小的范围内寻找 k/2-->O(1) 时间变换是什么？ 更小的范围是什么？

// A(k/ 2) >= B(K/2) --->A+B(K) 肯定不在B(k/2) 里面， 所以可以扔掉B(k/2)
// A(k/2) < B(K/2) ----> A + B (K) 肯定不在A(k/2) 里面， 所以可以扔掉A(k/2)

// A 的长度不足k/2 扔掉B的 前 k/2
// B 的长度不足k/2 扔掉A的 前 k/2

// 结束
// A 数组到头
// B 数组到头
// 或者 k = 1