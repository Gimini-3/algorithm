import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<arr.length;i++){
            int x = arr[i];
            int y=-1;
            if(deque.size()>0)y = deque.peekLast();
            if(x==y){
                continue;
            }else{
                deque.addLast(x);
            }            
        }
    
        int[] answer = deque.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        return answer;
    }
}