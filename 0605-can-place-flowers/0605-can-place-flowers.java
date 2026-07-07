class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0){
            return true;
        }

        int count = 0;
        
        for(int i=0; i<=flowerbed.length-1; i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 ||flowerbed[i+1] == 0)){
                count++;

                if(count == n){
                    return true;
                }
                i++;
            }
            
        }
        return false;
    }
    // public boolean canPlaceFlowers(int[] flowerbed, int n) {
    //     if (n == 0){
    //         return true;
    //     }
        
    //     for(int i=0; i<=flowerbed.length-1; i++){
    //         if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 ||flowerbed[i+1] == 0)){
    //             flowerbed[i] = 1;
    //             n--;

    //             if(n < 0){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
}