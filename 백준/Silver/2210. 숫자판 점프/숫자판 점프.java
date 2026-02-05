import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int cnt=0;
    public static int[] dx= {-1,0,0,1};
    public static int[] dy= {0,-1,1,0};
    public static Deque<String> stack= new ArrayDeque<>();
    public static Set<String> set = new HashSet<>();
    public static String [][]arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[5][5];
        StringTokenizer st;
        for(int i=0;i<5;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                arr[i][j]=st.nextToken();
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                stack.push(arr[i][j]);
                f(i,j,1);
                stack.pop();
            }
        }

        System.out.println(cnt);
    }

    public static void f(int x,int y,int lev){
        if(lev==6){
            StringBuilder sb=new StringBuilder();
            for(String s:stack){
                sb.append(s);
            }
            
            if(!set.contains(sb.toString())){
                cnt++;
                set.add(sb.toString());
           //     System.out.println(sb);
            }
            return;
        }
        for(int i=0;i<4;i++){
            int nextX= x+dx[i];
            int nextY= y+dy[i];
            if(nextX<0||nextX>4||nextY<0||nextY>4)continue;
            stack.push(arr[nextX][nextY]);
            f(nextX,nextY,lev+1);
            stack.pop();
        }
    }
}