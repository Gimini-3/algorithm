import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        String str = sca.next();
        int arr[]=new int[2];
        int swi= str.charAt(0)=='0'?0:1;
        arr[swi]++;
        for(int i=1;i<str.length();i++){
            int x= str.charAt(i)-'0';
            if(swi!=x){
                swi=x;
                arr[swi]++;
            }
        }
        System.out.println(Math.min(arr[0],arr[1]));
    }
}