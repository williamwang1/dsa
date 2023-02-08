import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DS_Top_K_Largest_Numbers {

    public static void main (String[] argus) {
        DS_Top_K_Largest_Numbers ds = new DS_Top_K_Largest_Numbers();
        int[] nums = new int[]{3, 10, 1000, -99, 4, 100};
        ds.topk(nums, 3);
    }

    public int[] topk(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int counter = k - 1;
        while (!minHeap.isEmpty()) {
            result[counter--] = minHeap.poll();
        }

        // for (int i = 0; i < result.length; i++) {
        //      result[k - i - 1] = minHeap.poll();
        // }
        return result;
    }
//public int[] topk(int[] nums, int k) {
//    // write your code here
//    if(k>nums.length || nums.length==0){
//        return null;
//    }
//    PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
//        public int compare(Integer a, Integer b){
//            //int difference = Integer.parseInt(a)-Integer.parseInt(b);
//            //int difference = a - b;
//            //return -1*difference;
//            return  b - a;
//        }
//    });
//    for(int num: nums){
//        pQueue.add(num);
//    }
//    int[] res = new int[k];
//    for(int i=0;i<k;i++){
//        int max = pQueue.poll();
//        res[i] = max;
//    }
//    return res;
//
//}

//    }

}
