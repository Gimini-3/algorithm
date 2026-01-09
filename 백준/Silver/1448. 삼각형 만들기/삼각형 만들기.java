import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
      //  for(int i=0;i<arr.length;i++){
      //      System.out.print(arr[i]+" ");
      //  }System.out.println();

        for(int i=n-1;i>1;i--){
            if(arr[i]<arr[i-1]+arr[i-2]){
                int sum = arr[i]+arr[i-1]+arr[i-2];
                System.out.println(sum);
                return;
            }
        }
        System.out.println(-1);
    }
}

 