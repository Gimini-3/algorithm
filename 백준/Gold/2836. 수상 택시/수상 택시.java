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

        List<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x>y)list.add(new Pair(y,x));
        }
        list.sort((a,b)->{
            if(a.x!=b.x){
                return Integer.compare(a.x,b.x);
            }else{
                return Integer.compare(a.y,b.y);
            }
        });
       // for(Pair p:list){
      //      System.out.printf("p.x:%d p.y:%d\n",p.x,p.y);
      //  }
        long sum = (long)m;
        int left = -1 ;
        int right = -1;
        for(int i=0;i<list.size();i++){
            Pair p = list.get(i);
            if(p.x>right){
                sum+=(long)(right-left)*2;
                left=p.x;
                right=p.y;
            }else if(p.x<=right){
                right=Math.max(right,p.y);
            }
        }
        sum+=(long)(right-left)*2;
        System.out.println(sum);
    }

    public static class Pair{
        public int x;
        public int y;
        public Pair(int x,int y){
            this.x= x;
            this.y=y;
        }
    }
}
