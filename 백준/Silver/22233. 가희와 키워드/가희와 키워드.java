import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            set.add(str);
        }

        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()){
                String str = st.nextToken();
     //           System.out.println(str);
                set.remove(str);
            }
            System.out.println(set.size());
        }
    
    }
}