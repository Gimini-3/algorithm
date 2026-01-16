import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String str =br.readLine();
           // System.out.println(str);
            int dot = str.lastIndexOf('.');
            String sp = str.substring(dot+1);
            
            //System.out.println(sp.length);
            map.put(sp,map.getOrDefault(sp,0)+1);
        }
        List<String> list= new ArrayList<>(map.keySet());
        
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            String str =list.get(i);
            System.out.println(str+" "+map.get(str));
        }
    }


}