class Solution {
    public boolean increasingTriplet(int[] nums) {
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;

        for(int i=0; i<=nums.length-1; i++){
            if(p1>=nums[i]){
                p1 = nums[i];
            } else if(p2>=nums[i]){
                p2 = nums[i];
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