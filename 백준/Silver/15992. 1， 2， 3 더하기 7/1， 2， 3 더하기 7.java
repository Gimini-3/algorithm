import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st;
        long arr[][] = new long[1001][1001];
        arr[1][1]=1;
        arr[2][1]=1;
        arr[2][2]=1;
        arr[3][1]=1;
        arr[3][2]=2;
        arr[3][3]=1;
        for(int i=4;i<1001;i++){
             for(int j=2;j<=i;j++){
                 if(i==j)arr[i][j]=1;
                 else if(i<j)continue;
                 arr[i][j] = (arr[i-1][j-1]+arr[i-2][j-1]+arr[i-3][j-1])%1000000009;
             }
        }
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(arr[x][y]);
        }
    }
}