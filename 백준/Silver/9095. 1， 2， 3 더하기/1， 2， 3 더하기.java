import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sca= new Scanner(System.in);
        int t = sca.nextInt();
        int dp[] = new int[12];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<12;i++){
            dp[i]+=dp[i-1];
            dp[i]+=dp[i-2];
            dp[i]+=dp[i-3];
        }
        for(int i=0;i<t;i++){
            int x= sca.nextInt();
            System.out.println(dp[x]);
        }
    }
    
}