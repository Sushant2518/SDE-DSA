class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for(int i=0; i<=operations.length-1; i++){
            String str = operations[i];
            if(str.equals("--X") || str.equals("X--")){
                x--;
            }
            else{
                x++;
            }
        }
        return x;
    }
}