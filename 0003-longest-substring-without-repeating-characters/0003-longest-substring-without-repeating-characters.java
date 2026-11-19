import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        int max = 0;
        int i=0;
        int j=0;
        int count = 0;
        int n = s.length(); 
        while(j<n){
            char ch = s.charAt(j);
            while(hs.contains(ch)){
            hs.remove(s.charAt(i));
            i++;
            }
            j++;
            hs.add(ch);
            count = j-i;
            max = Math.max(count, max);
        }       
        return max;
    }
}