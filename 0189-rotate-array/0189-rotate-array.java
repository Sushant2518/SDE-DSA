class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        rotateArrayByK(nums, 0, nums.length-1);

        rotateArrayByK(nums, 0, k-1);
        
        rotateArrayByK(nums, k, nums.length-1);

    }

    public static void rotateArrayByK(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}