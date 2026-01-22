import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    //머리, 왼쪽팔, 오른쪽,아래
    public static int dx[]={-1,0,0,1,1,1};
    public static int dy[]={0,-1,1,0,-1,1};
    public static char arr[][];
    public static int heartX=-1;
    public static int heartY=-1;
    public static int n;
    //왼쪽 팔, 오른쪽 팔, 몸통, 왼쪽 다리, 오른쪽 다리 순
    public static int result[]=new int[5]; 
    public static int bodyX=-1;
    public static int bodyY=-1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr= new char[n][n];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j]=str.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='*'){
                    int check =0;
                    for(int t=0;t<4;t++){
                        int nextX=i+dx[t];
                        int nextY=j+dy[t];
                        if(nextX<0||nextY<0||nextX>n-1||nextY>n-1)continue;
                        if(arr[nextX][nextY]=='*')check++;
                    }
             //           System.out.println(check);
                    if(check==4){
                        heartX=i;
                        heartY=j;
                        break;
                    }
                }
            }
        }
        System.out.println((heartX+1)+" "+(heartY+1));
       f(heartX,heartY,1,0); //왼쪽팔
       f(heartX,heartY,2,1);  //오른쪽팔
       f(heartX,heartY,3,2);  //몸통
      //  System.out.println(bodyX+" "+bodyY);
        result[3]=1;
        result[4]=1;
       f(bodyX+1,bodyY-1,3,3); //왼쪽 다리
       f(bodyX+1,bodyY+1,3,4); //오른쪽 다리
        for(int i=0;i<5;i++)System.out.print(result[i]+" ");
    }

    public static void f(int x,int y,int dire,int idx){
        
        int nextX=x+dx[dire];
        int nextY = y+dy[dire];
        if(nextX<0||nextY<0||nextX>n-1||nextY>n-1||arr[nextX][nextY]=='_'){
            if(idx==2){
                bodyX=x;
                bodyY=y;
            }
            return;
        }
        result[idx]++;
        f(nextX,nextY,dire,idx);
    }
}