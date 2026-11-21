class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;        
        while(i < m && j < n ){
            if(nums1[i] <= nums2[j]){
                mergedArray[k] = nums1[i];
                i++;
                k++;
            }else{
                mergedArray[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i<m){
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n){
            mergedArray[k] = nums2[j];
            j++;
            k++;
        } 
        for(int l=0; l<m+n; l++){
            nums1[l] = mergedArray[l];
        }
    }
}