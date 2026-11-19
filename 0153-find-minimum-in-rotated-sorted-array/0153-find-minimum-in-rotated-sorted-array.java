class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        if(nums[0] > nums[1]){
            return nums[1];
        }
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }
        if( nums[n-1] < nums[n-2] ){
            return nums[n-1];
        }
        int start= 1;
        int end = n-2;
        while( start <= end){
            int mid = (end+start)/2;
            if((nums[mid] < nums[mid+1]) && (nums[mid] < nums[mid-1])){
                return nums[mid];
            }else if(nums[0]>nums[mid]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }
}