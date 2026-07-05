class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());

        for(int len = minLength; len>=1; len--){
            String candidate = str1.substring(0, len);

            if(isDivisor(str1, candidate) && isDivisor(str2, candidate)){
                return candidate;
            }
        }
        return "";
    }

    private boolean isDivisor(String str, String candidate) {
        if(str.length() % candidate.length() != 0){
            return false;
        }

        int repeat = str.length()/candidate.length();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<=repeat-1; i++){
            sb.append(candidate);
        }

        return sb.toString().equals(str);
    }
}