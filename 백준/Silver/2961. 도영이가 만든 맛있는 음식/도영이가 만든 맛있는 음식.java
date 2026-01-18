import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Pair(s,b));
        }
        int min= Integer.MAX_VALUE;
        for(int mask=1;mask<1<<n;mask++){
            int resultS=1;
            int resultB=0;
            for(int i=0;i<n;i++){
                int bit = 1<<i;
                if((mask&bit)!=0){
                    Pair p = list.get(i);
                    resultS*= p.s;
                    resultB+=p.b;
                }
            }
      //     System.out.println(resultS+" "+resultB);
            int dif= Math.abs(resultB-resultS);
            min = Math.min(min,dif);
        }
        System.out.println(min);
        
            




    }

    public static class Pair{
        int s;
        int b;
        public Pair(int s, int b){
            this.s=s;
            this.b=b;
        }
    }
}