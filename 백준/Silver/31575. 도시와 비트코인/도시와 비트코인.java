import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int[] dx= {0,1};
    public static int[] dy= {1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(br.readLine());
        int m= Integer.parseInt(st.nextToken());
        int n= Integer.parseInt(st.nextToken());
    
        int [][] arr = new int[n][m];
        int [][] che = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int x= Integer.parseInt(st.nextToken());
                arr[i][j]=x;
            }
        }

        Queue<Pair> queue= new ArrayDeque<>();
        queue.offer(new Pair(0,0));
        che[0][0]=1;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int x= p.x;
            int y = p.y;
            if(x==n-1&&y==m-1){
                    System.out.println("Yes");
                    return;
             }
            
            for(int i=0;i<2;i++){
                int nextX  = x+ dx[i];
                int nextY = y+dy[i];
                if(nextX<0||nextX>n-1||nextY<0||nextY>m-1)continue;
                if(arr[nextX][nextY]==0)continue;
                if(che[nextX][nextY]==1)continue;
                che[nextX][nextY]=1;
                queue.offer(new Pair(nextX,nextY));
            }
        }
        System.out.println("No");
    }

    public static class Pair{
        public int x;
        public int y;
        public Pair(int x ,int y){
            this.x = x;
            this.y = y; 
        }
    }
}