import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] ci= new Integer[citations.length];
        for(int i=0;i<ci.length;i++){
            ci[i]=citations[i];
        }
        Arrays.sort(ci, Collections.reverseOrder());
        System.out.println(ci[0]);
        for(int i=0;i<ci.length;i++){
            int h=i+1;
            if(ci[i]>=h){
                answer=h;
            }else{
                break;
            }
        }
        return answer;
        
    }
}