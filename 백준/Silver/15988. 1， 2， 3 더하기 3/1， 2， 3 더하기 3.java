import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sca= new Scanner(System.in);
        int t = sca.nextInt();
        long dp[] = new long[1000001];
        dp[1]=1l;
        dp[2]=2l;
        dp[3]=4l;
        for(int i=4;i<1000001;i++){
            dp[i]=(dp[i]+dp[i-1])%1000000009;
            dp[i]=(dp[i]+dp[i-2])%1000000009;
            dp[i]=(dp[i]+dp[i-3])%1000000009;
        }
        for(int i=0;i<t;i++){
            int x= sca.nextInt();
            System.out.println(dp[x]);
        }
    }
    
}