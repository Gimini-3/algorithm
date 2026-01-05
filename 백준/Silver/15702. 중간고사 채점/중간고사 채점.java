import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] =new int[n];
        List<Pair> list =new ArrayList<>();
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<m;i++){
            int sum=0;
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            for(int j=0;j<n;j++){
                String s = st.nextToken();
                if(s.equals("O")){
                    sum+=arr[j];
                }
            }
          //  System.out.println(sum);
            list.add(new Pair(a,sum));
        }

        list.sort((a,b)->{
           if(a.y!=b.y){
               return Integer.compare(b.y,a.y);
           } else{
               return Integer.compare(a.x,b.x);
           }
        });
        Pair first = list.get(0);
        System.out.println(first.x+" "+first.y);
    }
    public static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}