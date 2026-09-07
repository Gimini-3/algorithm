import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        int x = progresses[0];
        int y = speeds[0];
        int z = (100-x)%y==0?(100-x)/y:(100-x)/y+1;
        int first= z;
        int second =-1;
        int count = 1;
        
        for(int i=1;i<progresses.length;i++){
            x = progresses[i];
            y = speeds[i];
            z = (100-x)%y==0?(100-x)/y:(100-x)/y+1;
            second =z;
            if(first>=second){
                count++;
            }
            else {
                
                deque.addLast(count);
                count=1;
                first= second;

            }
        }
        
        deque.addLast(count);
        int[] answer = deque.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        
        return answer;
    }
}