import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(dq.isEmpty())dq.addLast(arr[i]);
            else{
                int x= dq.peekLast();
                if(x==arr[i]){
                    continue;
                }else{
                    dq.addLast(arr[i]);
                 //   System.out.println(arr[i]);
                }
            }
        }
        int[] answer = new int[dq.size()];
        int size= dq.size();
        for(int i=0;i<size;i++){
            //System.out.println(dq.peek());
            answer[i]=dq.pollFirst();
        }
        return answer;
    }
}