import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int r;
    public static int g;
   public static Set<Integer> set;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        int x= gcd(Math.max(r,g),Math.min(r,g));
     //   System.out.println(x);
        divisors(x);
        StringBuilder sb;
        for(Integer s:set){
            sb=new StringBuilder();
                sb.append(s).append(" ")
                  .append(r/s).append(" ")
                  .append(g/s);  
            System.out.println(sb.toString());
        }
    }

    public static int gcd(int p, int q){
        if(p%q==0){
            return q;
        }else{
            return gcd(q, p%q);
        }
    }

    public static void divisors(int n){
        StringBuilder sb =new StringBuilder();
        for(int i=1;i*i<=n;i++){
            
            if(n%i==0){
                set.add(i);
                set.add(n/i);
            }
        }
    }
}