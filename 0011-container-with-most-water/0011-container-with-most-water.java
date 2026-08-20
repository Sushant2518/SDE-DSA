class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(left < right){
            int diff = right-left;
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, diff*min);
            if(height[left] < height[right]){
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }
}