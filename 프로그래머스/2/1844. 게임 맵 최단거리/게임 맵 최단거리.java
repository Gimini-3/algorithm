import java.util.*;

class Solution {
    public static int[] dx = {-1,0,0,1};
    public static int[] dy = {0,-1,1,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n=maps.length;
        int m = maps[0].length;
        Deque<Node> que = new ArrayDeque<>();
        que.add(new Node(0,0));
        int [][] visited = new int[n][m];
        visited[0][0]=1;
        visited[n-1][m-1]=-1;
        while(!que.isEmpty()){
            Node now = que.pollFirst();
            
            for(int i=0;i<4;i++){
                int nextX= now.x+dx[i];
                int nextY = now.y + dy[i];
                if(nextX<0||nextX>=n||nextY<0||nextY>=m)continue;
                if(maps[nextX][nextY]==0)continue;
                if(visited[nextX][nextY]>0)continue;
                visited[nextX][nextY]=visited[now.x][now.y]+1;
                que.addLast(new Node(nextX,nextY));
            }
            
        }
       
        answer= visited[n-1][m-1];
        
        
        return answer;
    }
    
    public class Node{
        int x; 
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}