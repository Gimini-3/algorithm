import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        List<Integer> list2 = new ArrayList<>();
        for(int i=1;i<list.size();i++){
            int b= list.get(i);
            int a = list.get(i-1);
            list2.add(b-a);
        }
       
        list2.sort((X,Y)->{return Integer.compare(Y,X);});
        int sum =0;
        for(int i=x-1;i<list2.size();i++){
            sum+=list2.get(i);
        }
        System.out.println(sum);
        
    }
}