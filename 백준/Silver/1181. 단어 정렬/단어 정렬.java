import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
             String str= br.readLine();
            set.add(str);
        }

        List<String> list = new ArrayList<>(set);
        list.sort((x,y)->{
            if(x.length()!=y.length()){
                return x.length()>y.length()?1:-1;
            }else {
                return x.compareTo(y);
            }
        });

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}