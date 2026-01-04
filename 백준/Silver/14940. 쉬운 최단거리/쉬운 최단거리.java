import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int N;
    public static int M;
    public static int[][] arr;
    public static int[][] result;
    public static int[][] checked;
    public static int startX;
    public static int startY;
    public static int []dx={-1,0,0,1};
    public static int []dy={0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        result = new int[N][M];
        checked = new int[N][M];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int t= Integer.parseInt(st.nextToken());
                if(t==2){
                    startX=i;
                    startY=j;
                }
                arr[i][j]=t;
            }
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(startX, startY));
        checked[startX][startY]=1;
        while(!queue.isEmpty()){
            Pair p= queue.poll();
            int x= p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nextX =x+dx[i];
                int nextY =y+dy[i];
                if(nextX<0||nextX>N-1||nextY<0||nextY>M-1)continue;
                if(checked[nextX][nextY]==1)continue;
                if(arr[nextX][nextY]==0)continue;
                checked[nextX][nextY]=1;
                result[nextX][nextY]=result[x][y]+1;
                queue.add(new Pair(nextX,nextY));
            }
        }
        
        for(int i=0;i<N;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<M;j++){
                if(arr[i][j]!=0&&arr[i][j]!=2&&result[i][j]==0){
                    sb.append("-1").append(" ");
                }
                else sb.append(result[i][j]).append(" ");
            }System.out.println(sb);
        }
    }

    public static class Pair{
        public int x; 
        public int y;
        public Pair(int x, int y){
            this.x= x;
             this.y = y;
        }
    }
}