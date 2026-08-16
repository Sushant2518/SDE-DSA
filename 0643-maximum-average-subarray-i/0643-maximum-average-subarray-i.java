class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY;
        double windowSum = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd <= nums.length-1; windowEnd++){
            double windowAverage = 0;
            windowSum += nums[windowEnd];

            if(windowEnd >= k-1){
                windowAverage = windowSum / k;
                maxAverage = Math.max(windowAverage, maxAverage); 
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return maxAverage;
    }
}