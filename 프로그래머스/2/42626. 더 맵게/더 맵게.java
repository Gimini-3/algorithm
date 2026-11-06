import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        while(true){
            if(pq.isEmpty()){
                return -1;
            }
            if(pq.peek()>=K){
                break;
            }
            if(pq.size()==1){
                return -1;
            }
            int x= pq.poll();
            int y = pq.poll();
            int z= x+y*2;
            pq.add(z);
          //  System.out.println(z);
            answer++;
        }
        return answer;
    }
}