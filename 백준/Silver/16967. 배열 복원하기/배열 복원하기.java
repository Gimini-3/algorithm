import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());
        int arr[][] =new int[n+x][m+y];
        for(int i=0;i<n+x;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m+y;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int result[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int before_x=i-x;
                int before_y=j-y;
                if(before_x<0||before_y<0){
                    result[i][j]=arr[i][j];
                }
                else result[i][j]=arr[i][j]-result[before_x][before_y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(result[i][j]+" ");
            }sb.append('\n');
        }
        System.out.println(sb);
    }
}