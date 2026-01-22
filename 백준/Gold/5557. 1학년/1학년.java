import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int n;
    public static int num=0;
    public static Set<Integer> set;
    public static int sum=0;
    public static int value[] = {1,5,10,50};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long [][]result = new long[21][n];
        int []arr= new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        result[arr[0]][0]=1;
        for(int j=0;j<n-2;j++){
            int next=arr[j+1];
            for(int i=0;i<=20;i++){
                if(result[i][j]>0){
                    
                    int minus= i-next;
                    int plus= i+next;
            //        System.out.printf("i:%d j:%d minus:%d plus:%d\n",i,j,minus,plus);
                    if(minus>=0)result[minus][j+1]+=result[i][j];
                    if(plus<=20)result[plus][j+1]+=result[i][j];
                }
            }
        }
    //   for(int i=0;i<21;i++){
   //         for(int j=0;j<n;j++){
   //             System.out.print(result[i][j]+" ");
   //         }System.out.println();
   //     }
        System.out.println(result[arr[n-1]][n-2]);
    }

    
       
}