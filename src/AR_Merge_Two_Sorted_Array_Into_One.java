public class AR_Merge_Two_Sorted_Array_Into_One {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] > A[i]) {
                A[index] = B[j--];

            } else {
                A[index] = A[i];
                i--;
            }
            index--;
        }
        while(i >= 0) {
            A[index] = A[i];
            index--;
            i--;
        }
        while(j >= 0) {
            A[index] = B[j];
            index--;
            j--;
        }

    }
}

// https://www.lintcode.com/problem/merge-sorted-array/description

// to avoid A change too much, insert into empty slot first..