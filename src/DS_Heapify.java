public class DS_Heapify {

    public void heapify(int[] A) {
        // write your code here
        // why from second last level ??? not from first level ?
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        }

    }

    private void siftdown(int[]A, int parent) {
        while (parent < A.length) { // ??? when parent in upper level, need to swap till leaf node
            int smallest = parent;
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;

            if (leftChild < A.length && A[leftChild] < A[smallest]) {
                smallest = leftChild;
            }
            if (rightChild < A.length && A[rightChild] < A[smallest]) {
                smallest = rightChild;
            }
            if (smallest == parent) {
                break;
            }
            swap(A, smallest, parent);
            parent = smallest;
        }
    }

    private void swap(int[]A, int parent, int child) {
        int temp = A[parent];
        A[parent] = A[child];
        A[child] = temp;
    }

}

// data structrue part 2 00：50：25

// O(n) shift down

// O(nlogn) shift up

 //基本操作——Heapify
// http://www.lintcode.com/problem/heapify/ http://www.jiuzhang.com/solutions/heapify/
// https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/DemoH eapify.pdf

// sift down, swap node and child node, why start from last second level ? why not start from second level

// sift up, swap node and parent node, why start from second level ?

/**
 * siftdown non-recursion
    from element in 2nd last level

        1. find smallet index between parent, leftchild and rightchild
        2. if smallest is still parent, break
        3. swap parent and smallet
        4. make child as new parent, repeat from step 1, till end of array

*/
