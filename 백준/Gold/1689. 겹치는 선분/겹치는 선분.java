import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new TreeMap<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((x,y)->{
            return Integer.compare(x,y); 
        });
       // Collections.sort(list);
      //  for(Map.Entry<Integer,Integer> e :map.entrySet()){
      //      System.out.println(e.getKey()+" "+e.getValue());
      //  }

        int value=0;
        int max=0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            value+=e.getValue();
       //      System.out.println(e.getKey()+" "+e.getValue()+" "+value);
            max= Math.max(value,max);
        }
        System.out.println(max);
    }
}