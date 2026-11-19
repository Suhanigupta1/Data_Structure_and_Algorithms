import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums) {
            hs.add(num);
        }

        int ans = 0;

        for (int num : hs) {
            if (!hs.contains(num - 1)) {
                int count = 0;
                int curr = num;

                while (hs.contains(curr)) {
                    count++;
                    curr++;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}