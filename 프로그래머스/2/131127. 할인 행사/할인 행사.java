import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        for(int i=0;i<10;i++){
            if(map.containsKey(discount[i])){
                map.put(discount[i],map.get(discount[i])-1);
            }
        }
        int left=0;
        int right=9;
        while(true){
            int cnt=0;
            for(Map.Entry<String,Integer> entry: map.entrySet()){
                int value = entry.getValue();
                if(value<=0)cnt++;
            }
            if(cnt==want.length)answer++;
            if(right==discount.length-1){
                break;
            }
            if(map.containsKey(discount[left])){
                map.put(discount[left],map.get(discount[left])+1);
            }
            left++;
            right++;
            if(map.containsKey(discount[right])){
                map.put(discount[right],map.get(discount[right])-1);
            }
            
        }
        return answer;
    }
}