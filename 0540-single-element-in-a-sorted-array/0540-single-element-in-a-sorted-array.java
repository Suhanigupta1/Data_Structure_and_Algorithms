class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        if (nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-2]!=nums[n-1]){
            return nums[n-1];
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid]!= nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(nums[mid]==nums[mid-1]){
                mid= mid-1;
            }
            if(mid % 2==0){
                left = mid+2;
            }else{
                right = mid-1; 
            }
        }
        return -1;
    }
}