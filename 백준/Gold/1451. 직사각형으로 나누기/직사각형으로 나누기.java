import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        int arr[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            String str= br.readLine();
            for(int j=1;j<=m;j++){
                 arr[i][j]= str.charAt(j-1)-'0';
            }
        }

     //   for(int i=1;i<=n;i++){
     //       for(int j=1;j<=m;j++){
     //           System.out.print(arr[i][j]+" ");
    //        }System.out.println();
     //   }

        long sum[][] = new long[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i][j];
            }
        }

        
      //  for(int i=1;i<=n;i++){
      //      for(int j=1;j<=m;j++){
      //          System.out.print(sum[i][j]+" ");
      //      }System.out.println();
       // }

        long sum1=0;
        long sum2=0;
        long sum3=0;
        long max=0;
        
        for(int i=1;i<n;i++){
       //     System.out.println("1");
            for(int j=1;j<m;j++){
                sum1=sum[i][j];
                sum2=sum[i][m]-sum1;
                sum3= sum[n][m]-sum1-sum2;
                max=Math.max(sum1*sum2*sum3,max);
                sum2= sum[n][m]-sum[n][j];
                sum3= sum[n][m]-sum1-sum2;
                max=Math.max(sum1*sum2*sum3,max);
            }
        }
        
        //첫번째 직사각형이 가로 끝까지 먹은 경우
        for(int i=1;i<n;i++){
          //  System.out.println("2");
            sum1=sum[i][m];
            if(i!=n-1){
                // 두 번째 직사각형도 가로 끝까지 먹음 -> 세번째도 가로 끝까지 먹어야함
                // i가 n-1일때는 두 번쨰 직사각형 가로 끝까지 못 먹음
                for(int q=i+1;q<n;q++){
                    sum2= sum[q][m]-sum1;
                    sum3= sum[n][m]-sum1-sum2;
                    max=Math.max(sum1*sum2*sum3,max);
                }
            }
            // 두 번째 직사각형 남은 공간 중 세로 끝까지 먹음 -> 세번째도 남은 공간 중 세로 끝까지 먹어야함
            for(int q=1;q<m;q++){
                sum2= sum[n][q]-sum[i][q];
                sum3= sum[n][m]-sum1-sum2;
                max=Math.max(sum1*sum2*sum3,max);
            }                         
        }
            
        //첫번째 직사각형이 세로 끝까지 먹은 경우
        for(int j=1;j<m;j++){
        //    System.out.println("3");
            sum1=sum[n][j];
            if(j!=m-1){
                // 두 번째 직사각형도 세로 끝까지 먹음 -> 세번째도 세로 끝까지 먹어야함
                // j가 m-1일때는 두 번쨰 직사각형 세로 끝까지 못 먹음
                for(int q=j+1;q<m;q++){
                    sum2= sum[n][q]-sum1;
                    sum3= sum[n][m]-sum1-sum2;
                    max=Math.max(sum1*sum2*sum3,max);
                }
            }
            // 두 번째 직사각형 남은 공간 중 가로 끝까지 먹음 -> 세번째도 남은 공간 중 가로 끝까지 먹어야함
            for(int q=1;q<n;q++){
                sum2= sum[q][m]-sum[q][j];
                sum3= sum[n][m]-sum1-sum2;
                max=Math.max(sum1*sum2*sum3,max);
            }                  
        }

        System.out.println(max);
    }
}