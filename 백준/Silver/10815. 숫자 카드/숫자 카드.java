import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int x= Integer.parseInt(st.nextToken());
            if(set.contains(x)){
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }
        }
    }
}