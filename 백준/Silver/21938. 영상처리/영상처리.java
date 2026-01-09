import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int[][] check;
    public static int [][]arr;
    public static int[] dx= {-1,0,0,1};
    public static int[] dy = {0,-1,1,0};
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr =new int[n][m];
        check =new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                int z= Integer.parseInt(st.nextToken());
                arr[i][j]= (x+y+z)/3;
            }
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]>=T){
                    arr[i][j]=255;
                    queue.add(new Pair(i,j));
                }else{
                    arr[i][j]=0;
                }
            }
        }
    //    for(int i=0;i<n;i++){
    //        for(int j=0;j<m;j++){
    //            System.out.print(arr[i][j]+" ");
    //        }
      //      System.out.println();
    //    }

        int result=0;
      //  System.out.println(queue.size());
        while(!queue.isEmpty()){
             Pair p= queue.poll();
            int x =p.x;
            int y =p.y;
            if(check[x][y]==1)continue;
         //   System.out.println(x+" "+y);
            result++;
            check[x][y]=1;
            Queue<Pair> queue2 = new LinkedList<>();
            queue2.add(new Pair(x,y));
            while(!queue2.isEmpty()){
                
                Pair p2 = queue2.poll();
                int x2= p2.x;
                int y2=p2.y;
                for(int i=0;i<4;i++){
                    int nextX=x2+dx[i];
                    int nextY = y2+dy[i];
                    if(nextX<0||nextX>n-1||nextY<0||nextY>m-1)continue;
                    if(check[nextX][nextY]==1)continue;
                    if(arr[nextX][nextY]!=255)continue;
                 //   System.out.println("x:"+nextX+" y:"+nextY);
                    check[nextX][nextY]=1;
                    queue2.add(new Pair(nextX, nextY));
                }
            }
        }
        System.out.println(result);
        
    }

    public static class Pair{
        public int x;
        public int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}

 