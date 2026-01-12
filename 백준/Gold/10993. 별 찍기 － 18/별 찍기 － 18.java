import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int[][] arr;
    public static int[] arr2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        arr2= new int[11];
        arr2[1]=1;
        int sizeX=1;
        int sizeY=1;
        for(int i=2;i<=n;i++){
            sizeX= 2*sizeX+1;
            arr2[i]=sizeX;
            sizeY = 2*sizeY+3;
        }
     //   System.out.printf("n:%d sizeX:%d sizeY:%d arr2[n]:%d\n",n,sizeX,sizeY,arr2[n]);
        arr = new int[sizeX][sizeY];
        int startX;
        int startY;
        if(n%2==0){
            startX=sizeX-1;
        }else{
            startX=0;
        }
        startY=sizeY/2;
     //   System.out.printf("startX:%d startY:%d\n",startX,startY);

        if(n%2==0)f1(n,startX,startY);
        else f2(n,startX,startY);
        for (int i = 0; i < sizeX; i++) {
        StringBuilder sb = new StringBuilder(sizeY);
        for (int j = 0; j < sizeY; j++) {
            sb.append(arr[i][j] == 0 ? ' ' : '*');
        }

        int last = sb.length() - 1;
        while (last >= 0 && sb.charAt(last) == ' ') last--;   // 오른쪽 공백 제거

        if (last < 0) System.out.println();
        else System.out.println(sb.substring(0, last + 1));
}
    }

    //n 짝수일 때
    public static void f1(int n,int startX,int startY){
        if(n==0)return;
     //   System.out.printf("n:%d startX:%d startY:%d arr2[n]:%d\n",n,startX,startY,arr2[n]);
        int height = arr2[n];
        int i=0;
        while(height>0){
            arr[startX-i][startY+i]=1;
            arr[startX-i][startY-i]=1;
            i++;
            height--;
        }
        for(int j=startY-i+1;j<startY+i-1;j++){
           arr[startX-i+1][j]=1;
        }
        f2(n-1,startX-i+2,startY);
    }

    // n 홀수일 떄
    public static void f2(int n,int startX,int startY ){
      //  System.out.printf("n:%d startX:%d startY:%d arr2[n]:%d\n",n,startX,startY,arr2[n]);
        int height = arr2[n];
        int i=0;
        while(height>0){
            arr[startX+i][startY+i]=1;
            arr[startX+i][startY-i]=1;
            i++;
            height--;
        }
   //     System.out.println("1");
        for(int j=startY-i+1;j<startY+i-1;j++){
           arr[startX+i-1][j]=1;
        }
   //     System.out.println("2");
        
        f1(n-1,startX+i-2 ,startY);
    }    
}