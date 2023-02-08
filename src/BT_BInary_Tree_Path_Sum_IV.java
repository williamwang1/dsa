public class BT_BInary_Tree_Path_Sum_IV {
}

/**
 * LeetCode上同一题的官方Solution，感觉很好懂所以放上来。
 * 简单讲就是将每个数的前两位数作为unique key, 将其个位数作为value，放入hashmap中
 * 因此有 depth = key / 10, pos = key % 10，
 * left_child_key = (depth + 1) * 10 + pos * 2 - 1;
 * right_child_key = left_child_key + 1;
 *
 * 最后采用dfs直接求解
 *
 * */