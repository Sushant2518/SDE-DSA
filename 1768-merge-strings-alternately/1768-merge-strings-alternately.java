class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] arr = new char[word1.length()+word2.length()];

        int i = 0;
        int k = 0;

        while(i<=word1.length()-1 || i<=word2.length()-1){
            if(i<=word1.length()-1){
                arr[k] = word1.charAt(i);
                k++;
            }

            if(i<=word2.length()-1){
                arr[k] = word2.charAt(i);
                k++;
            }
            i++;
        }
        return String.valueOf(arr);
    }
}