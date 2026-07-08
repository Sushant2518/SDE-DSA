class Solution {
    public int compress(char[] chars) {
        int result = 0;
        int i = 0;

        while(i <= chars.length-1){
            int j = i;

            while(j <= chars.length-1 && chars[j] == chars[i]){
                j++;
            }

            int count = j-i;

            chars[result] = chars[i];
            result++;

            if(count > 1){
                String temp = Integer.toString(count);

                for(char c : temp.toCharArray()){
                    chars[result] = c;
                    result++;
                }
            }
            i = j;
        }
        return result;
    }
}