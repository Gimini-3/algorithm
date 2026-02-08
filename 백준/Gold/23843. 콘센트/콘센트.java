import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->{
            return Integer.compare(x,y);
        });
        int arr[]= new int[m];
        for(int i=0;i<m;i++){
            pq.add(0);
        }
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int x= Integer.parseInt(st.nextToken());
            list.add(x);
        }
        list.sort((a,b)->{return Integer.compare(b,a);});
        int time=0;
        for(int i=0;i<n;i++){
            int x= pq.poll();
      //      System.out.printf("x:%d time:%d list(i):%d\n",x,time,list.get(i));
            if(x>time){
                time=x;
                pq.add(time+list.get(i));
            }else{
                pq.add(time+list.get(i));
            }
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            if(x>time){
                time=x;
            }
        }
        System.out.println(time);
    }

 
}