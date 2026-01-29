import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int r= Integer.parseInt(st.nextToken());

        int [][]arr= new int[n][m];
        int [][]result= new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // 오른쪽 -> 아래 -> 왼쪽 -> 위 순서로
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        for(int i=0;i<(Math.min(n,m)+1)/2;i++){
            int startX=i;
            int startY=i;
            int endX=n-1-i;
            int endY=m-1-i;
            // 가로 길이
            int width= endY-startY+1; 
            // 세로 길이
            int length= endX-startX+1; 
            // 한바퀴 도는데 걸리는 이동 노드 수
            int turn = width*length-(width-2)*(length-2);

            // 실제 계산하면 되는 회전 수
            int newR = r%turn;
         //   System.out.printf("startX:%d startY:%d endX:%d endY:%d turn:%d newR:%d \n",startX,startY,endX,endY,turn,newR);
            //startX와 startY부터 오른쪽 아래 왼쪽 위 순으로 newR번만큼 돔 -> 멈췄을 때 노드가 startX, startY위치임
            int nowX=startX;
            int nowY=startY;
            int dire=0;
            for(int j=0;j<newR;j++){
                int ax = nowX+dx[dire];
                int ay= nowY+dy[dire];
                if(ax<startX||ax>endX||ay<startY||ay>endY){
                    dire=(dire+1)%4;
                }
                nowX= nowX+dx[dire];
                nowY = nowY+dy[dire];
            }
          //  System.out.println(nowX+" "+nowY);

            int X=startX;
            int Y=startY;
            result[X][Y]=arr[nowX][nowY];
            int startDire= 0;
            
            for(int j=0;j<turn-1;j++){
                int ax1 = X+dx[startDire];    
                int ay1 = Y+dy[startDire];
                if(ax1<startX||ax1>endX||ay1<startY||ay1>endY){
                    startDire=(startDire+1)%4;
                }
                X= X+dx[startDire];
                Y= Y+dy[startDire];

                int ax2 = nowX+dx[dire];
                int ay2= nowY+dy[dire];
                if(ax2<startX||ax2>endX||ay2<startY||ay2>endY){
                    dire=(dire+1)%4;
                }
                nowX= nowX+dx[dire];
                nowY = nowY+dy[dire];

                result[X][Y]=arr[nowX][nowY];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(result[i][j]+" ");
            }System.out.println();
        }
    }
}