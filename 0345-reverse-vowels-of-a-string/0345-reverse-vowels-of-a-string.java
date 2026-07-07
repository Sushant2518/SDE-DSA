class Solution {
    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = charArr.length-1;

        while(left < right){
            while(left < right && !isVowel(charArr[left])){
                left++;
            }

            while(left < right && !isVowel(charArr[right])){
                right--;
            }

            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;

            left++;
            right--;
        }
        return String.valueOf(charArr);
    }
}