import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
          BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st =new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        BigInteger x= nCk(n,m);
        System.out.println(x);
    }

    public static BigInteger nCk(int n,int k){
        k = Math.min(k,n-k);
        BigInteger big = BigInteger.ONE;
        for(int i=1;i<=k ;i++){
           big = big.multiply(BigInteger.valueOf(n-k+i))
                .divide(BigInteger.valueOf(i));
        }
        return big;
    }
}