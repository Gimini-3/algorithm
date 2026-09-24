import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        int index=0;
        for(int i=0;i<topping.length;i++){
            right.put(topping[i], right.getOrDefault(topping[i],0)+1);
        }
        int left_cnt= left.size();
        int right_cnt = right.size();
       // System.out.println("left: "+left_cnt+" right: "+right_cnt);
        
        while(index<topping.length){
            int now = topping[index];
            index++;
            left.put(now, left.getOrDefault(now,0)+1);
            if(right.get(now)==1){
                right.remove(now);
            }else{
                right.put(now, right.get(now)-1);
            }
            left_cnt= left.size();
            right_cnt = right.size();
         //   System.out.println("left: "+left_cnt+" right: "+right_cnt);
        
            if(left_cnt==right_cnt){
                answer++;
            }
        }
        return answer;
    }
}