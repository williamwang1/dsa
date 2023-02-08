public class TP_A_Template {
}

//    Sort Colors II
 //       http://www.lintcode.com/en/problem/sort-colors-ii/
 //       http://www.jiuzhang.com/solutions/sort-colors-ii/
//    Interleaving Positive and Negative Numbers
      //  http://www.lintcode.com/problem/interleaving-positive-and-negative- numbers/
//          http://www.jiuzhang.com/solutions/interleaving-positive-and-negative- integers/


// 对撞型， 一个数组，从两边往中间移动
    // two sum 类
        // Triangle Count
// partition 类
        // Patition array by odd and even
        // valid Palindrome
        // quick sort/quick select/nuts and bolts
// 根本上就是省略扫描多余状态
// if (A[i] 和 A[j] 满足某个条件)
//    j--
//    do something
// else if (A[i] 和 A[j] 不满足某个条件)
//    i ++
//    do something
//  else
//    do something i ++ or j--
// 前向型 或者追击型 一个数组，同时向前移动

// 窗口类指针移动模板
//for (i = 0; i < n; i++) {
//    while(j < n) {
//        if (满足条件) {
//            j++
//            更新状态
//        } else {
//            break
//        }

//        }
//        }
//更新状态
//}


/**
 *  滑动窗口算法框架
 void slidingWindow(string s,string t){
         *unordered_map<char,int>need,window;
        *for(char c:t)need[c]++;
        *
        *int left=0,right=0;
        *int valid=0;
        *while(right<s.size()){
        *         // c 是将移入窗口的字符
        *char c=s[right];
        *         // 右移窗口
        *right++;
        *         // 进行窗口内数据的一系列更新
        *...
        *
        *         debug 输出的位置
        *printf("window: [%d, %d)\n",left,right);
        *
        *
        *         // 判断左侧窗口是否要收缩
        *while(window needs shrink){
        *             // d 是将移出窗口的字符
        *char d=s[left];
        *             // 左移窗口
        *left++;
        *             // 进行窗口内数据的一系列更新
        *...
        *}
        *}
        *}
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


// 两个数组 并行型
