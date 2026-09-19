import java.util.*;
class Solution {
    
    static int[] dx= {0,1,-1,0};
    static int[] dy = {1,0,0,-1};  
    public int solution(int[][] land) {
        int answer = 0;
        Deque<Node> deque = new ArrayDeque<>();
        int[] lev = new int[land.length * land[0].length + 1];
        int[][] visited= new int[land.length][land[0].length];
        int level=1;
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                if(land[i][j]==1&&visited[i][j]==0){
                    deque.addLast(new Node(i,j,level));
                    visited[i][j]=level;
                    lev[level]+=1;
                    while(true){
                        if(deque.isEmpty()){
                            level++;      
                            break;
                        }
                        Node now = deque.pollFirst();
                        for(int t=0;t<4;t++){
                            int nextX= now.x+dx[t];
                            int nextY= now.y+dy[t];
                            if(nextX<0||nextX>=land.length||nextY<0||nextY>=land[0].length)continue;
                            if(land[nextX][nextY]==0)continue;
                            if(visited[nextX][nextY]!=0)continue;
                            visited[nextX][nextY]=level;
                            lev[level]+=1;
                            deque.addLast(new Node(nextX,nextY,now.lev));
                        }
                    }
                }      
                          

            }
        }  
       /** for(int i=0;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int i=0;i<land[0].length;i++){
            Set<Integer> set = new HashSet<>();
            int count=0;
            for(int j=0;j<land.length;j++){
                if(visited[j][i]!=0){
                    set.add(visited[j][i]);
                }
            }
            
            for(int x : set){
                count+=lev[x];
            }
          //  System.out.println(count);
            answer=Math.max(answer,count);
        }
        return answer;
    }
    
    public class Node{
        int x;
        int y;
        int lev;
        public Node(int x,int y,int lev){
            this.x=x;
            this.y=y;
            this.lev = lev;
        }
    }
}