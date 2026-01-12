import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st  =new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }
        list.sort((x,y)->{
            return Integer.compare(y,x);
        });
        int sum =list.get(0);
        int result = 0;
        for(int i=1;i<n;i++){
            int x = list.get(i);
            result +=sum*x;
            sum+=x;
        }
        System.out.println(result);
    }
}