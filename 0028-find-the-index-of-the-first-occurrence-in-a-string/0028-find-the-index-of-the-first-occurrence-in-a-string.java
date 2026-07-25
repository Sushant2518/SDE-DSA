class Solution {
    public int strStr(String haystack, String needle) {
        int textLength = haystack.length();
        int patternLength = needle.length();

        if (patternLength == 0) {
            return 0;
        }

        for (int start = 0; start <= textLength - patternLength; start++) {

            int patternIndex = 0;

            while (patternIndex < patternLength &&
                    haystack.charAt(start + patternIndex) == needle.charAt(patternIndex)) {

                patternIndex++;
            }

            if (patternIndex == patternLength) {
                return start;
            }
        }

        return -1;
    }
}