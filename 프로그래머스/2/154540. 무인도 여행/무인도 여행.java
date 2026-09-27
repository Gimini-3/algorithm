import java.util.*;

class Solution {
    static int dx[]={0,-1,1,0};
    static int dy[] = {1,0,0,-1};
    
    public int[] solution(String[] maps) {
        
        int n = maps.length;
        int m =maps[0].length();
        int[] answer;
        Deque<Integer> ans_queue = new ArrayDeque<>();
        int[][] map= new int[n][m];
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = maps[i].charAt(j);
                if(ch=='X'){
                    map[i][j]=0;
                }else{
                    map[i][j]=(int)(ch-'0');
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }System.out.println();
        }
        
        Deque<Node> que;
        int sum;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]!=0)continue;
                if(map[i][j]==0)continue;
                
                que= new ArrayDeque<>();
                que.addLast(new Node(i,j));
                visited[i][j]=1;
                sum=0;
                while(!que.isEmpty()){
                    Node now = que.pollFirst();
                    sum+= map[now.x][now.y];
                    for(int t=0;t<4;t++){
                        int nextX=now.x+dx[t];
                        int nextY= now.y+dy[t];
                        if(nextX<0||nextY<0||nextX>n-1||nextY>m-1)continue;
                        if(map[nextX][nextY]==0)continue;
                        if(visited[nextX][nextY]!=0)continue;
                        visited[nextX][nextY]=1;
                        que.addLast(new Node(nextX,nextY));
                    }
                }
                ans_queue.addLast(sum);
                
            }
        }
        if(ans_queue.isEmpty()){
            answer = new int[1];
            answer[0]=-1;
        }else{
             answer = ans_queue.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        }
        Arrays.sort(answer);
    
        return answer;
    }
    
    class Node{
        int x;
        int y; 
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}