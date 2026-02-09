import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            list.add(ch-'0');
        }

        list.sort((x,y)->{return Integer.compare(y,x);});
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}