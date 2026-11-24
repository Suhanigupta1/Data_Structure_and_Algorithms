// Brute force approach 
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans  = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1; i>=0; i--){
            int j = i % n; 
            while(!st.isEmpty() && st.peek() <= nums[j]){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()){
                    ans[j] = -1;
                }else{
                    ans[j] = st.peek();
                }
            }
            st.push(nums[j]);
        }
        return ans;
    }
}


