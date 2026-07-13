class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;

        for(int i=0; i<=candies.length-1; i++){
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        for(int i=0; i<=candies.length-1; i++){
            if(candies[i]+extraCandies >= maxCandies){
                result.add(true);
            } else{
                result.add(false);
            }
        }

        return result;
    }
}