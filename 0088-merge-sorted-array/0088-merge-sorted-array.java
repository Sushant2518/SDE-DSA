class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Step 1: Copy nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Step 2: Bubble Sort
        int size = m + n;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (nums1[j] > nums1[j + 1]) {

                    // Swap
                    int temp = nums1[j];
                    nums1[j] = nums1[j + 1];
                    nums1[j + 1] = temp;
                }
            }
        }
    }
}