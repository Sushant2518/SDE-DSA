class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;

        for(int i=0; i<=timeSeries.length-2; i++){
            int currentAttack = timeSeries[i];
            int nextAttack = timeSeries[i+1];

            // if next attack occurs before current duration ends, include difference
            if(nextAttack <= (currentAttack + duration - 1)){
                total += nextAttack - currentAttack;
            } else{ // otherwise full duration
                total += duration;
            }
        }
        total += duration; // last attack
        return total;
    }
}