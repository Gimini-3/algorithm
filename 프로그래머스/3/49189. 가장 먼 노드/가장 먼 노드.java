import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]= new ArrayList<>();
        }        
        for(int i=0;i<edge.length;i++){
            int x = edge[i][0];
            int y = edge[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }
        
        int now_dist = 0;
        int cnt = 0;
        Deque<Node> deque = new ArrayDeque<>();
        int[] visited= new int[n+1];
        deque.addLast(new Node(0,1));
        visited[1]=1; 
        
        while(!deque.isEmpty()){
            Node now_node = deque.pollFirst();
            if(now_dist!=now_node.dist){
                cnt=1;
                now_dist=now_node.dist;
            }else{
                cnt++;
            }

            for(int i=0;i<graph[now_node.value].size();i++){
                int next_node_value= graph[now_node.value].get(i);
                if(visited[next_node_value]==1)continue;
                visited[next_node_value]=1;
                deque.addLast(new Node(now_node.dist+1, next_node_value));
            }
        }
        
        return cnt;
        
    }
    
    public class Node{
        int dist;
        int value;
        
        public Node(int dist, int value){
            this.value=value;
            this.dist=dist;
        }
    }
}