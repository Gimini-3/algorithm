import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num= nums.length;
        System.out.println(num);
        int x= num/2;
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<num;i++){
            set.add(nums[i]);
        }
        
        if(set.size()>=x){
            return x;
        }else{
            return set.size();
        }
    }
}