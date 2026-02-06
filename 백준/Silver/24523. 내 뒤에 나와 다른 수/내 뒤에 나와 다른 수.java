import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        List<Integer> list  = new ArrayList<>();
        int[] a= new int[n+1];
        for(int i=1;i<=n;i++){
            int x= Integer.parseInt(st.nextToken());
            a[i]=x;
        }
        int [] result= new int[n+1];
        result[n]=-1;

        int min_idx=n;
        int min_value=a[n];
        for(int i=n-1;i>=1;i--){
            int x= a[i];
            if(min_value==x){
                result[i]=result[i+1];
                min_idx=i;
            }else {
                result[i]=min_idx;
                min_idx=i;
                min_value=x;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}