import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine());

        int max_idx=-1;
        int max=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(max<arr[i]){
                max=arr[i];
                max_idx=i;
            }
        }

        int sum=0;
        for(int i=max_idx+1;i<n;i++){
            sum+=max+arr[i];
        }
        for(int i=max_idx-1;i>=0;i--){
            sum+=max+arr[i];   
        }
        System.out.println(sum);
    }
}