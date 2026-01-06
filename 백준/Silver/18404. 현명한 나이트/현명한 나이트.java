import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static int M;
    public static int [][]arr;
    public static int [][]trim;
    public static int nightX;
    public static int nightY;
    public static int []dx= {-2,-2,-1,-1,1,1,2,2};
    public static int []dy= {-1,1,-2,2,-2,2,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arr=new int[N][N];
        trim = new int[N][N];
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                trim[i][j]=-1;
            }
        }
        st=new StringTokenizer(br.readLine());
        int nightX = Integer.parseInt(st.nextToken())-1;
        int nightY = Integer.parseInt(st.nextToken())-1;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken())-1;
            int Y = Integer.parseInt(st.nextToken())-1;
            arr[X][Y]=1;
            list.add(new Pair(X,Y));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(nightX,nightY));
        trim[nightX][nightY]=0;
        while(!q.isEmpty()){
            Pair p= q.poll();
            int x=  p.x;
            int y = p.y;
            for(int i=0;i<8;i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                if(nextX<0||nextX>N-1||nextY<0||nextY>N-1){
                    continue;
                }
                if(trim[nextX][nextY]!=-1)continue;
                trim[nextX][nextY]= trim[x][y]+1;
                q.add(new Pair(nextX,nextY));
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0 ;i<list.size();i++){
            Pair p = list.get(i);
            sb.append(trim[p.x][p.y]).append(" ");
        }
        System.out.println(sb);
        
    }
    public static class Pair{
        public int x;
        public int y;
        public Pair(int x,int y){
            this.x = x;
            this.y= y;
        }
    }
}