import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int [][]arr;
    public static int [][]arr2;
    public static int [][]checked;
    public static int n;
    public static int m;
    public static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        arr2=new int[n][m];
        checked = new int[n][m];
        for(int i=0;i<n;i++){
             st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        if(arr[0][0]==1)arr2[0][0]=1;
        bfs(0,0);
     //   for(int i=0;i<n;i++){
    //        for(int j=0;j<m;j++){
    //            System.out.print(arr2[i][j]);
     //       }System.out.println();
      //  }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr2[i][j]>max)max=arr2[i][j];
            }
        }
        System.out.println(max);
        
    }

    public static void bfs(int x, int y){
        if(x+1<n){
   
            if(checked[x+1][y]==0||arr2[x+1][y]<arr2[x][y]+arr[x+1][y]){
                 arr2[x+1][y]=arr2[x][y]+arr[x+1][y];
                checked[x+1][y]=1;
                bfs(x+1,y);
            }
            
        }
        if(y+1<m){
            if(checked[x][y+1]==0||arr2[x][y+1]<arr2[x][y]+arr[x][y+1]){
                 arr2[x][y+1]=arr2[x][y]+arr[x][y+1];
                checked[x][y+1]=1;
                bfs(x,y+1);
            }          
        }
    }
}