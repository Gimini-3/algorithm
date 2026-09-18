import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<Node>[] list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i]= new ArrayList<>();
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b)->{
           return a.dist - b.dist;
        });
        
        int[] visited = new int[N+1];
        
        for(int i=0;i<road.length;i++){
            list[road[i][0]].add(new Node(road[i][1],road[i][2]));
            list[road[i][1]].add(new Node(road[i][0],road[i][2]));
        }

        pq.add(new Node(1,0));
        while(!pq.isEmpty()){
            
            Node nod = pq.poll();                
            if(visited[nod.num]==1)continue;

            visited[nod.num]=1;
            answer++;
            System.out.println(nod.num+" "+nod.dist);
            for(int i=0;i<list[nod.num].size();i++){
                Node nod2= list[nod.num].get(i);
               // System.out.println(nod.num+ " " + nod2.num+ " "+ nod2.dist);
                if(nod.dist + nod2.dist>K)continue;
                System.out.println(nod.num+ " " + nod2.num+ " "+ nod2.dist);
                pq.add(new Node(nod2.num,nod.dist+nod2.dist));
            }
        }
        return answer;
    }
    
    public class Node{
        int num;
        int dist;
        public Node(int num,int dist){
            this.num = num;
            this.dist = dist;
        }
    }
}