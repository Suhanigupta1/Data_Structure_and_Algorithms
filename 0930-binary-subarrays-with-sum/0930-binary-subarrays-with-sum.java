class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int count = 0;
        for(int i=0; i<n; i++){
            int target = prefix[i] - goal;
            if(hm.containsKey(target)){
                count+= hm.get(target);
            }
            hm.put(prefix[i], hm.getOrDefault(prefix[i],0) + 1);
        }
        return count;
    }
}