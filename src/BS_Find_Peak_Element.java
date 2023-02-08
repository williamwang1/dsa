public class BS_Find_Peak_Element {
}

// 但可以根据判断，保留下有解的那一半或者去掉无解的一半

//    There is an integer array which has the following features:

//        The numbers in adjacent positions are different.
 //       A[0] < A[1] && A[A.length - 2] > A[A.length - 1].

// 可以确保至少有一个peak

// mid in up wave, at least 1 peak in right
// mid in down wave, at least 1 leak in left
// mid in bottom, both ok.
// mid in peak, return

//http://www.lintcode.com/problem/find-peak-element/
 //       http://www.jiuzhang.com/solutions/find-peak-element/
//        follow up: Find Peak Element II (by 算法强化班)

