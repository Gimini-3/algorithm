import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        Map<String,Integer> map = new HashMap<>();
        while(true){
            String str = br.readLine();
            if(str==null){
          //      System.out.println("끝 "+ n);
                break;
            }
            n++;
            Integer i =map.get(str);
            i= (i==null)?1:i+1;
            map.put(str,i);
        }
      //  for(Map.Entry<String,Integer> e : map.entrySet()){
      //      System.out.println(e.getKey()+" " + e.getValue());
      //  }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((x,y)->{
           return x.compareTo(y);
        });
        
        for(String s:list){
            double value = (double)map.get(s);
            System.out.printf("%s %.4f",s, value/n*100);
            System.out.println();
            
        }
        
    }
}