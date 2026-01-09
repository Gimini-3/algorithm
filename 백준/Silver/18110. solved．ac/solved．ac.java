import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
       // for(int i=0;i<arr.length;i++){
     //       System.out.print(arr[i]+" ");
     //   }System.out.println();
        

        double x= (double)n*15/100;
        double t = Math.round(x);
        int v = (int)t;
  //      System.out.println(x+" "+t+" "+v);

        int m = n-2*v;
        int result =0;
        for(int i=v;i<n-v;i++){
            result+=arr[i];
        }
     //   System.out.println(m+" "+result);
        
        double ans = (double)result/(double)m;
        ans = Math.round(ans);
        System.out.println((int)ans);
    }
}

 