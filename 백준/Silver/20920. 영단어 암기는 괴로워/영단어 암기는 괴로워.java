import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            if(str.length()<m){
                continue;
            }
            Integer value = map.get(str);
            if(value==null){
                map.put(str,1);
            }else{
                map.put(str,value+1);
            }
            
        }
/*
        for( Map.Entry<String, Integer> e:map.entrySet()){
            System.out.println("key: "+e.getKey()+" value: "+e.getValue());
        }
*/
        Set<Map.Entry<String,Integer>> map2 = map.entrySet(); 
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map2);
       
            
         list.sort(new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
                int va = a.getValue();
                int vb = b.getValue();
                
                if(va!=vb){
                    return Integer.compare(vb,va);
                }else if(va==vb){
                    int x= a.getKey().length();
                    int y= b.getKey().length();
                    if(x!=y){
                        return Integer.compare(y,x);
                    }else if (x==y){
                        return a.getKey().compareTo(b.getKey());
                    }
                } 

                return 0;
            }
        });

        for(int i=0;i<list.size();i++){
             Map.Entry<String, Integer> result = list.get(i);
             bw.write(result.getKey());
             bw.newLine();
        }
        bw.flush();
    }
}    

  