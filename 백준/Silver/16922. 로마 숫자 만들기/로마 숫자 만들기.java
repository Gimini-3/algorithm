import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int n;
    public static int num=0;
    public static Set<Integer> set;
    public static int sum=0;
    public static int value[] = {1,5,10,50};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        set = new HashSet<>();
        for(int i=0;i<4;i++){
            sum+=value[i];
            f(1,i);
            sum-=value[i];
        }
        System.out.println(num);
    }

    public static void f(int dep, int idx){
       // System.out.printf("dep:%d idx:%d\n",dep,idx);
        if(dep==n){
            if(set.contains(sum)){
                return;
            }
             else{
                 set.add(sum);
                 num++;
             }   
            return;
        }
        
        for(int i=idx;i<4;i++){
            sum+=value[i];
            f(dep+1,i);
            sum-=value[i];
        }
    }
       
}