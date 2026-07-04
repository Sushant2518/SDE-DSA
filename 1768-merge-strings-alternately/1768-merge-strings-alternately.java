class Solution {
    public String mergeAlternately(String word1, String word2) {
        //Approach 1 : Brute force approach string concatenation T.C = o(n^2) S.C = o(n)
        // String ans = "";
        // int i = 0;

        // while(i<=word1.length()-1 || i<=word2.length()-1){
        //     if(i<=word1.length()-1){
        //         ans+=word1.charAt(i);
        //     }

        //     if(i<=word2.length()-1){
        //         ans+=word2.charAt(i);
        //     }
        //     i++;
        // }
        // return ans;

        // Approach 2 : Using StringBuilder T.C = o(n) S.c = o(m+n)
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while(i<=word1.length()-1 || i<=word2.length()-1){
            if(i<=word1.length()-1){
                ans.append(word1.charAt(i));
            }

            if(i<=word2.length()-1){
                ans.append(word2.charAt(i));
            }
            i++;
        }
        return ans.toString();


        

        // Approach 3
        // char[] ans = new char[word1.length()+word2.length()];
        // int i = 0;
        // int j = 0;
        // int k = 0;

        // while(i <= word1.length()-1 && i <= word2.length()-1){
        //     ans[k] = word1.charAt(i);
        //     k++;
        //     i++;

        //     ans[k] = word2.charAt(j);
        //     k++;
        //     j++;
        // }

        // while(i <= word1.length()-1){
        //     ans[k] = word1.charAt(i);
        //     k++;
        //     i++;
        // }

        // while(j <= word2.length()-1){
        //     ans[k] = word2.charAt(j);
        //     k++;
        //     j++;
        // }

        // return String.valueOf(ans);
    }
}