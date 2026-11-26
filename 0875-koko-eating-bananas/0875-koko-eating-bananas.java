class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxbanana = 0;
        int n = piles.length;
        for(int i=0; i<n; i++){
            maxbanana = Math.max(maxbanana, piles[i]);
        }
        int start = 1;
        int end = maxbanana;
        int ans = maxbanana;
        while( start <= end){
            int mid = start + (end-start)/2;
            if(canEat(piles, h, mid)){
                ans = Math.min(ans, mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int)ans;
    }

    public boolean canEat(int[] piles, int h, long minbanana){
        int n = piles.length;
        for(int i=0; i<n; i++){ 
            h -= piles[i]/minbanana;
            if(piles[i] % minbanana !=0){
                h--;
            }
            if(h<0){
                return false;
            }
        }
        return true;
    }
}


