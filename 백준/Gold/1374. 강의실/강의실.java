import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st =new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(st.nextToken());
            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(idx,start,end));
        }
        list.sort((x,y)->{
            if(x.start==y.start){
                return Integer.compare(x.end,y.end);
            }else{
                return Integer.compare(x.start,y.start);
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->{
                return Integer.compare(a,b);
            }
        );

        int count = 1;
        for(int i=0;i<list.size();i++){
            Node node = list.get(i);
            if(count>pq.size()){
                pq.offer(node.end);
            }else if(count==pq.size()){
                //강의실 개수와 쓰고있는 강의실 개수가 같을 때
                int first = pq.peek();
                if(first<=node.start){
                    pq.poll();
                    pq.offer(node.end);
                }else{
                    count++;
                    pq.offer(node.end);
                }
            }//lse if(count<pq.size()){
            //    
            //    while(!pq.isEmpty()){
           //         int first = pq.peek();
            //        if(first<=)
          //      }
         //   }
        }
        System.out.println(count);
    }

    public static class Node{
        int start;
        int end;
        int idx;
        public Node(int idx,int start,int end){
            this.idx= idx;
            this.start= start;
            this.end= end;
        }
    } 
}