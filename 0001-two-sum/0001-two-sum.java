import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length; 
        int[] ans = new int[2]; 
        for(int i=0; i<n; i++){
            int val = target - nums[i];
            if(hm.containsKey(val)){
                ans[0] = hm.get(val);
                ans[1] = i;
            }else{
                hm.put(nums[i],i);
            }
        }
        return ans;
    }
}