import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }
        list.sort((x,y)->{
            return Integer.compare(y,x);
        });

        int result = list.get(0);

        List<Integer> list2 = new ArrayList<>();
        list2.add(list.get(list.size()-1));
        for(int i=0;i<list.size()-1;i++){
            int x = list.get(i);
            int y = list.get(i+1);
            list2.add(x-y);
            
        }
        list2.sort((x,y)->{
            return Integer.compare(y,x);
        });
        for(int i=0;i<k;i++){
            result-=list2.get(i);
        }

        System.out.println(result);
        
    }
}