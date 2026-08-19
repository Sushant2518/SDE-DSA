class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return list;
        }

        // Step 1: Find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // Step 2: Check every integer in range (min, max)
        for (int i = min + 1; i < max; i++) {
            boolean found = false;
            
            // Step 3: Linear search for current number 'i' in nums
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }

            // Step 4: If not present in array, it's missing
            if (!found) {
                list.add(i);
            }
        }

        return list;
    }
}