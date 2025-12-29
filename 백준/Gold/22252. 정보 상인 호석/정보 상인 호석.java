import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<String,PriorityQueue<Integer>> map= new HashMap<>();
        long result =0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int t = Integer.parseInt(st.nextToken());
            if(x==1){
                PriorityQueue<Integer> pq;
                if(map.containsKey(name)){
                    pq = map.get(name);
                }else{
                    pq= new PriorityQueue<>(Collections.reverseOrder());
                    map.put(name,pq);
                }
                for(int j=0;j<t;j++){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
                
            }else if(x==2){
                if(!map.containsKey(name))continue;
                PriorityQueue<Integer> pq=map.get(name);
                if(pq.size()<t){
                    while(!pq.isEmpty()){
                        result+=pq.poll();
                    }
                }else{
                    for(int j=0;j<t;j++){
                        result+=pq.poll();
                    }
                }
                
            }
        }
        System.out.println(result);
    }
}