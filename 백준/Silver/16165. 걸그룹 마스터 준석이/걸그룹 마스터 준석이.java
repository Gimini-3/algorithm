import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        HashMap<String,List<String>> map = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();
        for(int i=0;i<n;i++){
            String str= br.readLine();
            int t = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for(int j=0;j<t;j++){
                String str2 = br.readLine();
                list.add(str2);
                map2.put(str2,str);
            }
            list.sort((a,b)->{
                return a.compareTo(b);
            });
            map.put(str,list);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            String str= br.readLine();
            int t= Integer.parseInt(br.readLine());
            if(t==1){
                sb.append(map2.get(str)).append('\n');
            }else if(t==0){
                List<String> list = map.get(str);
                for(int j=0;j<list.size();j++){
                    sb.append(list.get(j)).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}