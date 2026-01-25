import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        int [] dx= {-1,0,1,0};
        int []dy= {0,1,0,-1};
    
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int m = sca.nextInt();
        int [][] arr = new int[n][n];
        
        int x=n/2;
        int y=n/2;
        int dire=0;
        int move=1;  //같은 방향으로 이동하는 횟수
        int dire_count=0; //방향 두 번 전환시 move 1증가
        int count=0; // 이 방향으로 이동한 횟수 count=move이면 방향 전환
        arr[x][y]=1;
        int resultX=x+1;
        int resultY=y+1;
        for(int i=2;i<=n*n;i++){
            x= x+dx[dire];
            y= y+dy[dire];
            arr[x][y]=i;
            if(i==m){
                resultX=x+1;
                resultY=y+1;
            }
            count++;
            if(count== move){
                dire= (dire+1)%4;
                count =0;
                dire_count+=1;
                if(dire_count==2){
                    dire_count=0;
                    move+=1;
                }
            }           
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]).append(' ');
            }
            
            if(i!=n-1)sb.append('\n');
        }
        System.out.println(sb);
        System.out.println(resultX+ " "+resultY);
    }
}