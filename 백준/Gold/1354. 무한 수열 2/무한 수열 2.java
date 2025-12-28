import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static Long N;
    public static Long P;
    public static Long Q;
    public static Long X;
    public static Long Y;
    public static Map<Long, Long> map;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Long.parseLong(st.nextToken());
        P=Long.parseLong(st.nextToken());
        Q=Long.parseLong(st.nextToken());
        X=Long.parseLong(st.nextToken());
        Y=Long.parseLong(st.nextToken());
        System.out.println(f(N));
        
    }

    public static Long f(Long n){
        if(n<=0){
            return (long)1;
        }
        Long a= map.get(n);
        if(a!=null){
            return a;
        }
        Long x=f(n/P-X);
        Long y=f(n/Q-Y);
        map.put(n,x+y);
        return x+y;
    }

    
}    

  