import java.util.*;

class Solution {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    public int solution(String[] board) {
        int answer = -1;
        int check = 0;
        int n = board.length;
        int m = board[0].length();
        int[][] visited= new int[n][m];
        
        Deque<Node> dq = new ArrayDeque<>();
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j)=='R'){
                   dq.addLast(new Node(i,j));
                }
            }
        }
        
        while(!dq.isEmpty()){
            Node now = dq.poll();
           // System.out.println(now.x+" "+now.y+ " "+visited[now.x][now.y]);
            if(board[now.x].charAt(now.y)=='G'){
                
                return visited[now.x][now.y];
            }
            for(int i=0;i<4;i++){
                int nextX=now.x;
                int nextY=now.y;
                int turn=0;
                while(true){
                    nextX += dx[i];
                    nextY += dy[i];
                    if(nextX<0||nextY<0||nextX>n-1||nextY>m-1)break;
                    if(board[nextX].charAt(nextY)=='D')break;
                    turn++;
                }
                if(turn ==0)continue;
                nextX-=dx[i];
                nextY-=dy[i];
                if(visited[nextX][nextY]>0)continue;
                visited[nextX][nextY]=visited[now.x][now.y]+1;
                dq.add(new Node(nextX,nextY));
            }
        }
       
        
        return answer;
    }
    
    class Node{
        public int x;
        public int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}