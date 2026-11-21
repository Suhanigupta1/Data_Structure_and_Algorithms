import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = n - 1;

        // Step 1: Find pivot
        while (j >= 1 && nums[j - 1] >= nums[j]) {
            j--;
        }

        // Step 2: Find smallest element greater than pivot
        if (j > 0) {
            int pivot = j - 1;
            int min = j;

            for (int k = j; k < n; k++) {
                if (nums[k] > nums[pivot] &&
                    nums[k] <= nums[min]) {
                    min = k;
                }
            }

            int temp = nums[pivot];
            nums[pivot] = nums[min];
            nums[min] = temp;
        }

        // Step 3: Sort suffix
        Arrays.sort(nums, j, n);
    }
}