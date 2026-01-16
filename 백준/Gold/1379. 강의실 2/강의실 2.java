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
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                return Integer.compare(a.end,b.end);
            }
        );

        int count = 1;
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<list.size();i++){
            Node node = list.get(i);
            if(count>pq.size()){
                map.put(node.idx,count);
                pq.offer(new Pair(node.end,count));
            }else if(count==pq.size()){
                Pair first = pq.peek();
                if(first.end<=node.start){
                    Pair p = pq.poll();
                    map.put(node.idx,p.num);
                    
                    pq.offer(new Pair(node.end,p.num));
                }else{
                    count++;
                    map.put(node.idx,count);
                    pq.offer(new Pair(node.end,count));
                }
            }
        }
        System.out.println(count);
        for(int i=1;i<=n;i++){
            System.out.println(map.get(i));
        }
    }

    public static class Pair{
        int end;
        int num;
        public Pair(int end, int num){
            this.end= end;
            this.num=num;
        }
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