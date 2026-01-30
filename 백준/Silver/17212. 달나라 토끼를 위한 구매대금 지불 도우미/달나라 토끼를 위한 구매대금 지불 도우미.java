import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int dp[]=new int[n+1];
        if(n==0){
            System.out.println("0");
            return;
        }
        if(n>=1)dp[1]=1;
        if(n>=2)dp[2]=1;
        if(n>=5)dp[5]=1;
        if(n>=7)dp[7]=1;
        for(int i=3;i<=n;i++){
            if(dp[i]==0)dp[i]=Integer.MAX_VALUE;
            dp[i]=(i-1>0)?Math.min(dp[i],dp[i-1]+1):dp[i];
            dp[i]=(i-2>0)?Math.min(dp[i],dp[i-2]+1):dp[i];
            dp[i]=(i-5>0)?Math.min(dp[i],dp[i-5]+1):dp[i];
            dp[i]=(i-7>0)?Math.min(dp[i],dp[i-7]+1):dp[i];
        }
      //  for(int i=1;i<=n;i++){
     //       System.out.print(dp[i]+" ");
      //  }
        System.out.println(dp[n]);
    }
}