import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DS_Top_K_Largest_Numbers_II {

    PriorityQueue<Integer> minheap;
    int k;
    /*
     * @param k: An integer
     */public DS_Top_K_Largest_Numbers_II(int k) {
        // do intialization if necessary
        this.minheap = new PriorityQueue<>();
        this.k = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here

        minheap.add(num);
        if (minheap.size() > k) {
            minheap.poll();
        }
    }

    /*
     * @return: Top k element
        // write your code here
     */
    public List<Integer> topk() {
        List<Integer> result = new ArrayList<Integer>(minheap);
        // Iterator it = minheap.iterator();
        // while (it.hasNext()) {
        //     result.add((int)it.next());
        // }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}

/**
 * why miniheap ? not maxheap ?
 * minheap will poll smaller int and keep largest in heap
 *
 * Steps :
 * add -- add element, if size limit achive, poll
 *
 * Note :
 * 1. output reverse order
 * Collections.sort(result, Collections.reverseOrder());
 *
 *
 */

// http://www.lintcode.com/problem/top-k-largest-numbers-ii/
//        http://www.jiuzhang.com/solutions/top-k-largest-number-ii/

