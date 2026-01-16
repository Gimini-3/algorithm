import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list  =new ArrayList<>();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            String[] s= str.split("[^0-9]+");
            for(int j=0;j<s.length;j++){
                if(s[j].equals(""))continue;
             //   System.out.println(s[j]);
                int idx=f(s[j]);
                s[j]=s[j].substring(idx);
             //   System.out.println(s[j]);
                list.add(s[j]);
            }
        }
        list.sort((x,y)->{
            if(x.length()==y.length()){
                return x.compareTo(y);
            }else{
                return Integer.compare(x.length(),y.length());
            }
        });

        for(String i:list){
            System.out.println(i);
        }
    }

    // "0003"-> 처음 0이 아닌 위치 리턴
    public static int f(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='0'){
                return i;
            }
        }
        return str.length()-1;
    }

}