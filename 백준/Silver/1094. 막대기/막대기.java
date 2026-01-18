import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int now=n;
        int count =1;
        while(true){
            int len= 64;            
            while(len>now){
                len=len>>1;
            }
            //System.out.println(len);
            now-=len;
            if(now==0)break;
            




            count++;
        }
        System.out.println(count);
    }
}