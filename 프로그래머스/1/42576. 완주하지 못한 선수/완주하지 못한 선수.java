import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> set = new HashMap<>();
        
        for(int i=0;i<completion.length;i++){
            Integer a = set.get(completion[i]);
            if(a==null){
                set.put(completion[i],1);
            }
            else set.put(completion[i],a+1);
        }
        
        for(int i=0;i<participant.length;i++){
            Integer a= set.get(participant[i]);
            if(a==null||a==0){
                return participant[i];
            }
            set.put(participant[i],a-1);
        }
        return answer;
    }
}