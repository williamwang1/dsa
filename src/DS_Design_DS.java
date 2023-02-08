import java.util.*;

public class DS_Design_DS {

        public static void main (String[] args) {

        }


        ArrayList<Integer> nums;
        HashMap<Integer, Integer> num2index;
        Random rand;

        public DS_Design_DS() {
            // do initialize if necessary
            nums = new ArrayList<Integer>();
            num2index = new HashMap<Integer, Integer>();
            rand = new Random();
        }

        // Inserts a value to the set
        // Returns true if the set did not already contain the specified element or false
        public boolean insert(int val) {
            if (num2index.containsKey(val)) {
                return false;
            }

            num2index.put(val, nums.size());
            nums.add(val);
            return true;
        }

        // Removes a value from the set
        // Return true if the set contained the specified element or false
        public boolean remove(int val) {
            if (!num2index.containsKey(val)) {
                return false;
            }

            int index = num2index.get(val);
            if (index < nums.size() - 1) { // not the last one than swap the last one with this val
                int last = nums.get(nums.size() - 1);
                nums.set(index, last);
                num2index.put(last, index);
            }
            num2index.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        // Get a random element from the set
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
}


//https://www.jiuzhang.com/solution/insert-delete-getrandom-o1/

// 使用数组来保存当前集合中的元素，同时用一个hashMap来保存数字与它在数组中下标的对应关系。

/**

 possible data structrue ?
 insert O(1) -- map, arraylist
 remove O(1) -- map
 getRandom O(1) -- map, arraylist

 two data structrue
 1. arraylist
 2. hashmap, key --> val, value --> index in arraylist

 what is the clue for 1 above ?
 u need to collection to store, so we choose set or arraylist.

 why arraylist not set ?

 what is the clue for 2 above ?
 O(1) to remove value --> in arraylist, u need to know index to achive this, so value to index mapping is needed

 possible to use hashmap only ?
 if so, key---> val, value --> ??

 possible to use arraylist only ?
 no.. remove is not O(1)

     How to determine index of nums ?

 Note :
 rand.nextInt(nums.size()) --> wiil generate random between 0 to nums.size() -1

 Note :
 if u remove by index directly, the index of following element may change,
 so correct way is move the last number to current index, then remove the last(no need to care what is the last number after )


*/
