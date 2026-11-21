class Solution {
    public void sortColors(int[] nums) {
    int zeors = 0;
    int ones = 0;
    int twos = 0;
    for(int i=0; i<nums.length; i++){
        if(nums[i]==0){
            zeors++;
        }else if(nums[i]==1){
            ones++;
        }else{
            twos++;
        }
    }    
    int k=0;
    while(zeors>0){
        nums[k] = 0;
        k++;
        zeors--;
    }
    while(ones>0){
        nums[k] = 1;
        k++;
        ones--;
    }
    while(twos>0){
        nums[k] = 2;
        k++;
        twos--;
    }

    }
}