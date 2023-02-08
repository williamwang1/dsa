public class Longest_Valid_Parentheses {

}

// https://www.lintcode.com/problem/longest-valid-parentheses

/**
 * from left to right
 *      record valid no of left ( and right )
 *      compare no of left  ( and right )
 *      if =, update longest
 *      if right > left, left = right = 0
 *
 * from right to left
 *      record valid no of left ( and right )
 *        compare no of left  ( and right )
 *        if =, update longest
 *       if left > right, left = right = 0
 * */