class Solution {
    public int rob(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for(int i=0; i<nums.length; i++){
            int s = sum2 + nums[i];
            int s1 = Math.max(sum2,sum1);

            sum1 = s;
            sum2 = s1;
        }
        int res = Math.max(sum1,sum2);

        return res;
    }
}