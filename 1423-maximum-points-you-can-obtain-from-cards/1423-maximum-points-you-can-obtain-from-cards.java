class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if( n < k){
            return 0;
        }
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        if(n==k){
            return sum;
        }
        int Maxsum = sum;
        int j= k-1;
        int l = n-1;
        while(j>=0 && l > n-k-1){
            sum -= cardPoints[j];
            sum += cardPoints[l];
            j--;
            l--;
            Maxsum = Math.max(Maxsum, sum);
        }
        return Maxsum;
    }
}


