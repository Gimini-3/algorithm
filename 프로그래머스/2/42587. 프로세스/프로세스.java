import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Deque<pair> deque = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            pq.offer(priorities[i]);
            deque.addLast(new pair(priorities[i],i));
        }
        
        while(true){
            int max = pq.peek();
            pair first= deque.pollFirst();
            if(max>first.value){
                deque.addLast(first);
            }else if(max==first.value){
                answer++;
                pq.poll();
                if(first.location==location){
                    break;
                }
            }
        }
        
        return answer;
        
    }
    
    public class pair{
        public int value;
        public int location;
        
        public pair(int value,int location){
            this.value=value;
            this.location=location;
        }
    }
}