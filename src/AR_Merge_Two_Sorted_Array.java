public class AR_Merge_Two_Sorted_Array {

    public static void main(String[] argus) {
        AR_Merge_Two_Sorted_Array a = new AR_Merge_Two_Sorted_Array();
        int[] A = new int[]{1,2,3};
        int[] B = new int[]{4,5};
        a.mergeSortedArray(A, 3, B, 2);
    }

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int[] result = new int[m + n];
        int i = 0, j = 0, index = 0;
        // 处理 A 和 B 长度重合的元素
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                result[index] = A[i];
                i++;
            } else {
                result[index] = B[j];
                j++;
            }
            index ++;
        }
        // 处理 A剩余的元素
        while(i < m) {
            result[index] = A[i];
            index++;
            i++;
        }
        // 处理 B剩余的元素
        while(j < n) {
            result[index] = B[j];
            index++;
            j++;
        }

    }
}


///https://www.lintcode.com/problem/merge-two-sorted-arrays/description
