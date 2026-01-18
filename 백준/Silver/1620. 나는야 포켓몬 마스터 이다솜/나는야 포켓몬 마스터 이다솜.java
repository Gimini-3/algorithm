import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,String> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++){
            String str = br.readLine();
            map2.put(str,i);
            map1.put(i,str);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            String str = br.readLine();
            if(str.charAt(0)>'0'&&str.charAt(0)<='9'){
                int x = Integer.parseInt(str);
                sb.append(map1.get(x)).append('\n');
            }else{
                sb.append(map2.get(str)).append('\n');
            }
        }System.out.println(sb);


    }

    public static class Pair{
        int s;
        int b;
        public Pair(int s, int b){
            this.s=s;
            this.b=b;
        }
    }
}