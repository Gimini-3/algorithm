import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[1000001];
        int max = 0; 
        int left = 0;
        int right = 2*k;
        
        int sum=0;
        for(int i=0;i<n;i++){
             st= new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
            arr[y]=x;
        }
        if(right>=1000000){
            for(int i=0;i<=1000000;i++){
                sum+=arr[i];
            }
            System.out.println(sum);
            return;
        }
        for(int i=0;i<=right;i++){
            sum+=arr[i];
        }
        max = sum;
       // System.out.println(max);
        while(true){
            left++;
            right++;
            
            
            if(right==1000001){
                break;
            }
            sum+=arr[right];
            sum-=arr[left-1];
            if(max<sum){
                max=sum;
               // System.out.println(left+" "+right);
              //  System.out.println(max);
            }
        }
        System.out.println(max);
    }
}