import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            Long k= Long.parseLong(st.nextToken());
            Long N = (k%2==0)?k/2+1:k/2;
            int swi= 0;
         //   System.out.println(N+"명 달성 시 지배");
            HashMap<Long,Long> map =new HashMap<>();
            for(int j=0;j<k;j++){
                Long x= Long.parseLong(st.nextToken());
                Long t= map.get(x);
              //  System.out.printf("x:%d t:%d\n",x,t);
                if(t!=null&&t+1==N){
                    System.out.println(x);
                    swi=1;
                    break;
                }
                map.put(x, map.getOrDefault(x,(long)0)+1);
            }
             if(swi==0)System.out.println("SYJKGW");   
        }
                
        
    }
}