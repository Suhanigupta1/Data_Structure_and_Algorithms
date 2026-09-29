import java.util.*;
public class HashMapQ {
    public static void UnionOfTwoArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
           set.add(arr1[i]);
        }
        for(int j=0; j<arr2.length; j++){
           set.add(arr2[j]);
        }
        System.out.println(set);
    }

    public static int SubArraySumEqualToK(int[] arr, int k){
        HashMap<Integer, Integer> SubArraySumMap = new HashMap<>();
        int ans = 0;
        int sum = 0;
        SubArraySumMap.put(0, 1);
        for (int j=0; j < arr.length; j++){
            sum += arr[j];
            // 10, 12, 10, -10, 0
            //(10, 1)(12,1),(10,1),(-10, 1), ()

            // ans = 2
            if (SubArraySumMap.containsKey(sum - k)){
                ans += SubArraySumMap.get(sum - k);
            }  
            if (SubArraySumMap.containsKey(sum)){
                SubArraySumMap.put(sum, SubArraySumMap.get(sum) + 1);
            }else{
                SubArraySumMap.put(sum, 1);
            }
        }
        return ans;
    };
    
    public static void FindItinerary(HashMap<String, String> map) {
        String start = FindStartofTheTrip(map);
        // System.out.println("start =>" + start);
        while(map.containsKey(start)){
            System.out.print(start + "=>");
            start = map.get(start); 
        }
        System.out.println(start);

    }

    public static String FindStartofTheTrip(HashMap<String, String> map){
        HashMap<String, String> ReverseMap = new HashMap<>();
        for(String city : map.keySet()){
            ReverseMap.put(map.get(city), city);
        }
        for(String city : map.keySet()){
            if (!ReverseMap.containsKey(city)){
                return city;
            }
        }
        return null;
    }

    public static void IntersectionOfTwoArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
            for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
            }
            for(int j=0; j<arr2.length; j++){
            if (set.contains(arr2[j])){
                intersection.add(arr2[j]);
            }
            }
        System.out.println(intersection);
    }


    public static int MajorityElement(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int MajorityCount = n/3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > MajorityCount){
                System.out.println(nums[i] + ": " + map.get(nums[i]));
                ans += 1;
            }
        }       
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 6, 9, 1, 2, 3, 4, 5};
        int nums[] = {1, 2, 3, 5, 6, 7, 8, 9};
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(MajorityElement(nums));       
        UnionOfTwoArrays(nums1, nums2);
        IntersectionOfTwoArrays(nums1, nums2);
        HashMap<String, String> Itinerary = new HashMap<>();
        Itinerary.put("Chennai", "Bengluru");
        Itinerary.put("Mumbai", "Delhi");
        Itinerary.put("Goa", "Chennai");
        Itinerary.put("Delhi", "Goa");
        FindItinerary(Itinerary);
        System.out.println(SubArraySumEqualToK(arr, k));
    }
}