import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        Integer arr[]=new Integer[n];
        Integer arr2[]=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (x,y)-> Integer.compare(x,y));
        Arrays.sort(arr2, (x,y)-> Integer.compare(y,x));

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i]*arr2[i];
        }
        System.out.println(sum);
    }
}