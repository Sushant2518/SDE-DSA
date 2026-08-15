class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] preffix = new int[nums.length];
        int[] suffix = new int[nums.length];

        preffix[0] = 1;
        suffix[nums.length-1] = 1;

        for(int i=1; i<=nums.length-1; i++){
            preffix[i] = preffix[i-1] * nums[i-1];
        }

        for(int i=nums.length-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i=0; i<=nums.length-1; i++){
            answer[i] = preffix[i] * suffix[i];
        }

        return answer;
    }
}