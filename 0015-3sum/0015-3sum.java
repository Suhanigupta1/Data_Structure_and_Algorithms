import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; 
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+ nums[j] + nums[k];
                if (sum==0){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    res.add(arr);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}