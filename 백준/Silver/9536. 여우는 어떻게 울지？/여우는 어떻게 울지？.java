import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());

        for(int I=0;I<n;I++){
            StringTokenizer st  =new StringTokenizer(br.readLine());
            List<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());               
            }
            Set<String> set = new HashSet<>();
            while(true){
                String str = br.readLine();
                if(str.equals("what does the fox say?")){
                    break;
                }
                st= new StringTokenizer(str);
                st.nextToken();
                st.nextToken();
                String str2 = st.nextToken();
                set.add(str2);
            }
            StringBuilder sb = new StringBuilder();
            for(String s:list){
                if(set.contains(s)){
                    continue;
                }
                sb.append(s).append(" ");
            }
            System.out.println(sb);
        }
    }
}