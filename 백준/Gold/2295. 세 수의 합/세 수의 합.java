import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int n;
    public static int[] arr;
    public static int[] arr2;
    public static int idx =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        
        arr2 = new int[n*n];

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int x= arr[i]+arr[j];
                set.add(x);
            }
        }
      //  for(int v:set){
      //      System.out.print(v+" ");
      //  }System.out.println();

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                int x = arr[i]-arr[j];
                if(set.contains(x)){
                    System.out.println(arr[i]);
                    return;
                }
            }
        }      
    }

}