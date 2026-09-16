import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Node> heap2 = new PriorityQueue<>((Node a,Node b)->{
            if(a.start_time!=b.start_time){
                return a.start_time - b.start_time;
            }else {
                return a.num-b.num;
            }
        });
        for(int i=0;i<jobs.length;i++){
            heap2.add(new Node(i,jobs[i][0],jobs[i][1]));
        }
        PriorityQueue<Node> heap = new PriorityQueue<>((Node a,Node b)->{
            if(a.duration!=b.duration){
                return a.duration - b.duration;
            }else{
                if(a.start_time!=b.start_time){
                    return a.start_time - b.start_time;
                }else{
                    return a.num - b.num;
                }
            }
        });        

        int time = 0;

        while(!heap2.isEmpty()||!heap.isEmpty()){
            while(!heap2.isEmpty()&&heap2.peek().start_time<=time){
                Node nod= heap2.poll();
                System.out.println("nod.num:"+nod.num+" "+" nod.start_time:"+nod.start_time+" nod.duration:"+nod.duration);
                heap.add(nod);
            }
            if(heap.isEmpty()){
                Node nod = heap2.poll();
                heap.add(nod);
                time=nod.start_time;
                int x= nod.start_time;
                while(!heap2.isEmpty()&&heap2.peek().start_time==x){
                    Node nod2 = heap2.poll();
                    heap.add(nod2);
                }
            }    
            Node now_node = heap.poll();           
            time += now_node.duration;
            answer+= time- now_node.start_time;
            System.out.println("time:"+time+" now_node:"+now_node.num+" answer:"+answer);
        }
        answer/=jobs.length;
        return answer;
        
    }
    
    public class Node{
        int num;
        int start_time;
        int duration;
        
        public Node(int num, int start_time, int duration){
            this.num = num;
            this.start_time = start_time;
            this.duration = duration;
            
        }
    }
}