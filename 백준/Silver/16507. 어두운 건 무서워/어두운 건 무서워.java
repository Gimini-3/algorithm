import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int N;
    public static int M;
    public static int Q;
    public static int arr[][];
    public static int arr2[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        int sum=0;
        arr= new int[N+1][M+1];
        arr2= new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                int x = Integer.parseInt(st.nextToken());
                arr[i][j]=x;
                arr2[i][j]=x;
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                arr2[i][j]+=arr2[i-1][j]+arr2[i][j-1]-arr2[i-1][j-1];
            }
        }
    //    for(int i=1;i<=N;i++){
   //         for(int j=1;j<=M;j++){
   //             System.out.print(arr2[i][j]+" ");
  //          }System.out.println();
  //     }

        for(int i=0;i<Q;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int result = solve(x1,y1,x2,y2);
            int z= (y2-y1+1)*(x2-x1+1);
            
            System.out.println(result/z);
        }
    }

    public static int solve(int x1,int y1,int x2,int y2){
        int result = 0;
        result=arr2[x2][y2]- arr2[x1-1][y2]-arr2[x2][y1-1]+arr2[x1-1][y1-1];
     //   System.out.println(arr2[x2][y2]+" "+arr2[x2][y1]+" "+arr2[x1][y2]+" "+arr2[x1][y1]+" "+result);
        
        return result;
    }
}