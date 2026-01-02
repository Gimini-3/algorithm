import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int max = 0;
        int num=0;
        for(int i=0;i<x;i++){
            sum+=arr[i];
        }
        max=sum;
        num=1;
        int left=0;
        int right=x-1;
        while(true){
            if(right==n-1){
                break;
            }
            sum-=arr[left++];
            sum+=arr[++right];
            if(sum>max){
                max= sum;
                num=1;
            }else if(sum==max){
                num++;
            }
            
        }
        if(max==0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(num);
    }
}