import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(br.readLine()));
        }
        int [] arr = new int[k+1];
        for(int i=1;i<=k;i++){

            int min=Integer.MAX_VALUE;
            for(Integer j:set){
                if(i-j<0)continue;
                if(arr[i-j]==-1)continue;
                min = Math.min(min,arr[i-j]+1);
            }
            arr[i]=(min==Integer.MAX_VALUE)?-1:min;
        }
        //for(int i=1;i<=k;i++){
        //    System.out.print(arr[i]+" ");
        //}
        System.out.println(arr[k]);
        
        
    }
}