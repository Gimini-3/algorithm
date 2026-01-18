import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static Set<Integer> set;
    public static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str = br.readLine();
            String[] s = str.split(" ");
            int result=0;
            if(s.length==1)f(s[0]);
            else if (s.length==2){
                f2(s[0],Integer.parseInt(s[1]));
            }
        }
        System.out.println(sb);
    }

    public static void f(String str){
        if(str.equals("all")){
            set = new HashSet<>();
            for(int i=1;i<=20;i++){
                set.add(i);
            }
            
        }else if(str.equals("empty")){
            set=new HashSet<>();
        }
    }

    public static void f2(String str, int num){
        if(str.equals("add")){
            set.add(num);
        }else if(str.equals("remove")){
            if(set.contains(num)){
                set.remove(num);
            }
        }else if(str.equals("check")){
            int che = (set.contains(num))?1:0;
            sb.append(che).append('\n');
        }else if(str.equals("toggle")){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
    }
    
}