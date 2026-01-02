import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int n;
    public static BufferedWriter bw;
    public static int []bad;
    public static int []good;
    public static int life=100;
    public static int max=0;
    public static int sum=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        bad = new int[n];
        good = new int[n];
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            bad[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            good[i]=Integer.parseInt(st.nextToken());
        }
        f(0);
        System.out.println(max);
    }

    public static void f(int idx){
       if(idx==n){
           if(life<=0){
                return;
            }
            
           // System.out.println(sum);
            if(sum>max){
                max= sum;
            }
            return;
        }
        f(idx+1);
        sum+=good[idx];
        life-=bad[idx];
        f(idx+1);
        sum-=good[idx];
        life+=bad[idx];
    }

}