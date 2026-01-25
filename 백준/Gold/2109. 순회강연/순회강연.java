import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<node> pq = new PriorityQueue<>((a,b)->{
            if(a.p!=b.p){
                return Integer.compare(b.p,a.p);
            } else{
                return Integer.compare(b.d,a.d);
            }
        });

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            int p=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            pq.offer(new node(p,d));
      //      System.out.println(p+" "+d);
        }
        int time=1;
        long sum=0;
        int arr[]= new int[10001];
        while(!pq.isEmpty()){
            node node = pq.poll();
            int nodeP= node.p;
            int nodeD= node.d;
     //       System.out.println("asdf"+nodeP+" "+nodeD);
            int che =0;
            for(int i=nodeD;i>0;i--){
                if(arr[i]==0){
                    arr[i]=1;
                    sum+=nodeP;
              //      System.out.println(nodeD+" "+sum);
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    public static class node{
        int p;
        int d;
        public node(int p,int d){
            this.p = p;
            this.d = d;
        }
    }
}