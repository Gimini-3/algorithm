import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set= new HashSet<>();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            String[] st= str.split(" ");
            if(st[1].equals("enter")){
                set.add(st[0]);
            }else{
                if(set.contains(st[0])){
                    set.remove(st[0]);
                }
            }
        }
        List<String> list = new ArrayList<>(set);
        list.sort((x,y)->{
            return y.compareTo(x);
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}