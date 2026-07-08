class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int k = Integer.MAX_VALUE;

        for(int x=0; x<=nums.length-1; x++){
            if(nums[x] <= i){
                i = nums[x];
            } else if(nums[x] <= j){
                j = nums[x];
            } else {
                return true;
            }
        }
        return false;
    }
    // public boolean increasingTriplet(int[] nums) {
    //     // With this approach some test cases getting Time Limit Exceeded
    //     for(int i=0; i<=nums.length-1; i++){
    //         for(int j=i+1; j<=nums.length-1; j++){
    //             for(int k=j+1; k<=nums.length-1; k++){
    //                 if(nums[i]<nums[j] && nums[j]<nums[k]){
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }
}