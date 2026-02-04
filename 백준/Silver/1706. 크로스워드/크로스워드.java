import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static List<String> list = new ArrayList<>();
    public static StringBuilder sb=new StringBuilder();
    public static boolean [][]check_under;
    public static boolean [][]check_right;
    public static int[] dx={1,0}; // 0:밑 1: 오른쪽
    public static int[] dy={0,1}; 
    public static int n;
    public static int m;
    public static char [][]arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr =new char[n][m];
        check_under= new boolean[n][m];
        check_right = new boolean[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=str.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='#')continue;
                if(!check_under[i][j]){
                    check_under[i][j]=true;
                    sb.setLength(0);
                    sb.append(arr[i][j]);
                    f(i,j,0,1);
                }
                if(!check_right[i][j]){
                    check_right[i][j]=true;
                    sb.setLength(0);
                    sb.append(arr[i][j]);
                    f(i,j,1,1);
                }
            }
        }

      //  for(int i=0;i<list.size();i++){
      //      System.out.println(list.get(i));
      //  }
        list.sort((a,b)->{
            return a.compareTo(b);
        });
        System.out.println(list.get(0));
    }

    public static void f(int x,int y,int dire,int lev){
        int nextX= x+dx[dire];
        int nextY= y+dy[dire];
        if(nextX>n-1||nextY>m-1||arr[nextX][nextY]=='#'){
            if(lev==1){
                return;
            }else{
                list.add(sb.toString());
                return;
            }
        }
        if(dire==0)check_under[nextX][nextY]=true;
        if(dire==1)check_right[nextX][nextY]=true;
        sb.append(arr[nextX][nextY]);
        f(nextX,nextY,dire,lev+1);
    }
}