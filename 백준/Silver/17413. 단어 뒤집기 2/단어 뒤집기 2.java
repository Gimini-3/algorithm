import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int swi=0;
        StringBuilder sb= new StringBuilder();
        StringBuilder sb2= new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch=='<'){
                sb.append(sb2.reverse());
                sb2.setLength(0);
                swi=1;
                sb.append('<');
                continue;
            }
            if(ch=='>'){
                sb.append(sb2);
                sb2.setLength(0);
                swi=0;
                sb.append('>');
                continue;
            }
            if(swi==1){
                sb2.append(ch);
            }else if(swi==0){
                if(ch==' '){
                    sb.append(sb2.reverse());
                    sb2.setLength(0);
                    sb.append(' ');
                }else{
                    sb2.append(ch);
                }
            }
        }
        sb.append(sb2.reverse());
        System.out.println(sb);
    }


}