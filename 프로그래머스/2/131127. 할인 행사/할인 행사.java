import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer= 0;
        int cnt= 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            cnt+=number[i];
            map.put(want[i],number[i]);
        }
       
        int idx=0;
        for(int i=0;i<cnt;i++){
            if(map.containsKey(discount[i]))map.put(discount[i],map.get(discount[i])-1);
        }
        int left=0;
        int right=cnt;
        int num=want.length;
        for(Map.Entry<String,Integer> e : map.entrySet()){
            if(e.getValue()<=0){
                num-=1;
            }
        }
        if(num==0)answer++;
        
        while(right<discount.length){
            if(map.containsKey(discount[left])){
                int x= map.get(discount[left]);
                if(x==0){
                    num+=1;
                }
                map.put(discount[left],x+1);
            }
            if(map.containsKey(discount[right])){
                int x= map.get(discount[right]);
                if(x==1){
                    num-=1;
                }
                map.put(discount[right],x-1);
            }
               left++;
               right++;
               if(num==0)answer++;
        }        
        
        
        return answer;
    }
}
