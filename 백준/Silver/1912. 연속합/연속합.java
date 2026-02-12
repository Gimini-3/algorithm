import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] arr =new int[n+1];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        dp[0]=arr[0];
        int max= dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
            max= Math.max(dp[i],max);
        }
        System.out.println(max);
        
    }
    
}