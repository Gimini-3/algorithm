import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int n;
    public static int[] arr;
    public static int[] check;
    public static int s;
    public static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        check = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());            
        }
        s= Integer.parseInt(br.readLine());
        result++;
        f(s-1);
        System.out.println(result);
    }

    public static void f(int start){
        int left = start-arr[start];
        int right = start+arr[start];
       // System.out.println("start: "+start+"left: "+left+"right: "+right);
        if(left>=0&&check[left]==0){
       //     System.out.println("left: "+ left);
            check[left]=1;
            result++;
            f(left);
        }
        if(right<n&&check[right]==0){
         //   System.out.println("right: "+ right);
            check[right]=1;
            result++;
            f(right);
        }
    }
}