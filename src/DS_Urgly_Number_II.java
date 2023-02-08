import java.util.*;

public class    DS_Urgly_Number_II {
    public int nthUglyNumber(int n) {
        // write your code here
        Queue<Long> minheap = new PriorityQueue<Long>();
        Set<Long> duplicates = new HashSet();
        Long[] prime = new Long[]{Long.valueOf(2), Long.valueOf(3), Long.valueOf(5)};
        minheap.add(Long.valueOf(1));
        duplicates.add(Long.valueOf(1));
        int seq = 0;
        while (!minheap.isEmpty()) {
            Long val = minheap.poll();
            seq++;
            if (seq == n) {
                return val.intValue();
            }
            for (int i = 0; i < prime.length; i++) {
                if (!duplicates.contains(val * prime[i])) {
                    minheap.add(val * prime[i]);
                    duplicates.add(val * prime[i]);
                }
            }
        }
        return 0;
    }
}

/**
 * Question :
 * How to inspire to use heap ?
 * find nth in dynamic array ---> heap
 *
 * Steps :
 *
 * 1. add first element
 * 2. poll element, step++, add prime facor into queue
 * 3. repeat 2 ,end condition when step == n
 *
 * Note:
 * 1. Set to control duplicates
 * 2. value will be quite large, so use Long instead of int
 * 3. inital step = 0
 *
 *
 *
 */

// http://www.lintcode.com/problem/ugly-number-ii/
//http://www.jiuzhang.com/solutions/ugly-number-ii/
