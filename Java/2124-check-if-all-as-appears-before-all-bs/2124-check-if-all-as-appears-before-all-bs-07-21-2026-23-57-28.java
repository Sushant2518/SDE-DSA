class Solution {
    public boolean checkString(String s) {
        if(s.length() == 0){
            return false;
        }

        for(int i=1; i<=s.length()-1; i++){
            if(s.charAt(i)<s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}