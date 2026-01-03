import java.io.*;
import java.util.*;

class Main {
    public static int N;
    public static int M;
    public static int K;
    public static int result=0;
    public static int sum=0;
    public static String []arr;
    public static int [][]check;
    public static int[] dx=new int[]{-1,0,0,1};
    public static int[] dy = new int[]{0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr =new String[N];
        check = new int[N][M];
        for(int i=0;i<N;i++){
            arr[i]=br.readLine();
         //   System.out.println(arr[i]);
        }
        f(N-1,0);
        System.out.println(result);
    }
    public static void f(int x, int y){
        
      //  System.out.println("x:"+x+"y:"+y+"sum:"+sum);
        if(x==0&&y==M-1){
            if(sum+1==K){
                result++;
            }
            return;
        }
        sum++;
        check[x][y]=1;
        for(int i=0;i<4;i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX<0||nextX>N-1||nextY<0||nextY>M-1)continue;
            if(check[nextX][nextY]==1)continue;
            if(arr[nextX].charAt(nextY)=='T')continue;
            f(nextX,nextY);
        }
        check[x][y]=0;
        sum--;
    }
}