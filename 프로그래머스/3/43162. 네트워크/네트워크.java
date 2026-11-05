import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        Deque<Integer> que = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                visited[i]=1;
                que.add(i);
                answer++;
                while(!que.isEmpty()){
                    
                    int now = que.poll();
                    for(int j=0;j<n;j++){
                        if(j==now)continue;
                        if(computers[now][j]==0)continue;
                        if(visited[j]==1)continue;
                        visited[j]=1;
                        que.addLast(j);
                    }
                }
            }
            
        }
        
        return answer;
    }
}