import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        Scanner sca = new Scanner(System.in);
        String str = sca.next();
        int [] dp = new int[str.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=1;i<str.length();i++){
            String s= str.substring(i-1,i+1);
           // System.out.println(s);
            if(s.charAt(0)!='0'){
                int x= Integer.parseInt(s);
                if(x<35){
                    dp[i+1]+=dp[i-1];
                }
            }
            if(str.charAt(i)!='0')dp[i+1]+=dp[i];
          //  System.out.printf("dp[%d]:%d\n",i+1,dp[i+1]);
        }
        System.out.println(dp[str.length()]);
    }
}