import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(int i=0;i<n-1;i++){
            String str = br.readLine();
            int x= map.get(str);
            if(x==1){
                map.remove(str);
            }else{
                map.put(str,x-1);
            }
        }
        for(String str:map.keySet()){
            System.out.println(str);
        }
    }
}