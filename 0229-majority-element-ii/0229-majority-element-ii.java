class Solution {
    public List<Integer> majorityElement(int[] nums) {
    int candidate1 = nums[0]; 
    int candidate2 =  nums[0];
    int n = nums.length;
    int count1 = 0;
    int count2 = 0;
    for(int i=0; i<n; i++){
        if(candidate1== nums[i]){
            count1++;
        }else if(candidate2 == nums[i]){
            count2++;
        }else if(count1 == 0){
            candidate1 = nums[i];
            count1++;
        }else if(count2 == 0){
            candidate2 = nums[i];
            count2++;
        }else{
            count1--;
            count2--;
        }
    }   
    int a = 0;
    int b = 0;
    for(int num : nums){
        if(num == candidate1){
            a++;
        }else if(num == candidate2){
            b++;
        }
    }
    List<Integer> ls = new ArrayList<>();
    if(a > n/3){
        ls.add(candidate1);
    }
    if(b > n/3){
        ls.add(candidate2);
    }
    return ls;
    }
}