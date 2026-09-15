import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]= new ArrayList<>();
        }
        
        for(int i=0;i<n-1;i++){
            int x= wires[i][0];
            int y = wires[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }
        int[] check;
        Deque<Integer> deque;
        for(int i=0;i<n-1;i++){
            int x= wires[i][0];
            int y = wires[i][1];
            check = new int[n+1];
            deque = new ArrayDeque<>();
            deque.addLast(x);
            check[x]=1;
            int count =1;
            while(!deque.isEmpty()){
                int now_node = deque.pollLast();
                for(int j=0;j<graph[now_node].size();j++){
                    int next_node = graph[now_node].get(j);
                    if(check[next_node]==1)continue;
                    if(now_node==x&&next_node==y)continue;
                    if(now_node==y&&next_node==x)continue;
                    check[next_node]=1;
                    count++;
                    deque.addLast(next_node);
                }
            }
            int diff = n-2*count;
            answer = Math.min(answer, Math.abs(diff));
        }
        
        return answer;
    }
}