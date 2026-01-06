import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static int M;
    public static int []dx= {-1,0,0,1};
    public static int []dy= {0,-1,1,0};
    public static int [][]arr;
    public static int [][]checked;
    public static int [][]result;
    public static int [][]arr2;
    public static List<Pair> list;
    public static List<Pair> list2;
    public static Queue<Pair> queue;
    public static int vvv=1;
    public static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        result = new int[N][M];
        arr2 = new int[N][M];
        list= new ArrayList<>();
        list2= new ArrayList<>();
        queue = new LinkedList<>();
        checked = new int[N][M];
        for(int i=0;i<N;i++){
            String str =br.readLine();
            for(int j=0;j<M;j++){
                char c = str.charAt(j);
                int x= c-'0';
                if(x==0){
                    list.add(new Pair(i,j));
                }
                if(x==1){
                    list2.add(new Pair(i,j));
                }
                arr[i][j]=x;
            }
        }

        for(int i=0;i<list.size();i++){
            
            Pair p = list.get(i);
            if(checked[p.x][p.y]!=0)continue;
            sum=1;
            checked[p.x][p.y]=vvv;
            queue.add(new Pair(p.x,p.y));
            f(p.x,p.y);
            while(!queue.isEmpty()){
                Pair p2 = queue.poll();
                arr2[p2.x][p2.y]=sum;
            }
            vvv++;
        }
        for(int i=0;i<list2.size();i++){
            Pair p =list2.get(i);
            Set<Integer> set= new HashSet<>();
            for(int j=0;j<4;j++){
                int nextX= p.x+dx[j];
                int nextY = p.y+dy[j];
                if(nextX<0||nextY<0||nextX>N-1||nextY>M-1)continue;
                int aa= checked[nextX][nextY];
                if(set.contains(aa))continue;
                result[p.x][p.y]+=arr2[nextX][nextY];
                set.add(aa);
            }
            result[p.x][p.y]+=1;
        }
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder(M);

        for(int i=0;i<N;i++){
            sb.setLength(0);
            for(int j=0;j<M;j++){
                sb.append(result[i][j]%10);
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        
    }

    public static void f(int x, int y){

        for(int i=0;i<4;i++){
            int nextX= x+dx[i];
            int nextY = y+dy[i];
            if(nextX<0||nextY<0||nextX>N-1||nextY>M-1)continue;
            if(arr[nextX][nextY]==1)continue;
            if(checked[nextX][nextY]!=0)continue;
            checked[nextX][nextY]=vvv;
            queue.add(new Pair(nextX,nextY));
            sum++;
            f(nextX,nextY);
        }
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