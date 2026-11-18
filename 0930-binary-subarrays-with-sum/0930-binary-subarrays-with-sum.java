class Solution {
    public int atmostgoal(int[] nums, int goal){
        if(goal<0){
            return 0;
        }
        int i=0; 
        int j=0;
        int res = 0;
        int sum=0;
        int n = nums.length;
        while(j < nums.length){
            sum += nums[j];
            while(sum>goal){
                sum -= nums[i];
                i++;
            }
            res += (j-i+1);   
            j++;     
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmostgoal(nums, goal) - atmostgoal(nums, goal-1);
    }
}