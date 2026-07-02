class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;

        s = s.replaceAll("^\\s+", "");
        s = s.replaceAll("\\s+$", "");

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                len = 0;
            else
                len++;
        }

        return len;
    }
}