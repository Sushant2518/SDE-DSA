class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str = "";

        if(word1.length()<1 && word2.length()<1){
            return str;
        }

        int i = 0;

        while(i<=word1.length()-1 || i<=word2.length()-1){
            if(i<=word1.length()-1){
                str += word1.charAt(i);
            }

            if(i<=word2.length()-1){
                str += word2.charAt(i);
            }
            i++;
        }
        return str;
    }
}