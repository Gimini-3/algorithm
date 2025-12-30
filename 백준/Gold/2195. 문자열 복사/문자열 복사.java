import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        int result = 0;

        int start =0 ;
        boolean flag = false;
        StringBuilder sb=new StringBuilder();
        while(true){ 
            if(start>=P.length()){
                result++;
                System.out.println(result);
                return;
            }
            if(!flag){  //문자열 끝 다시 시작
                sb= new StringBuilder();
                flag=true;
            }
            sb.append(P.charAt(start));
           // System.out.println(sb.toString());
            if(!S.contains(sb.toString())){
                // 문자열이 포함 안되면
                // start 증가 x
                flag =false;
                result++;
            }else{
                start++;
            }
        }
    }
}