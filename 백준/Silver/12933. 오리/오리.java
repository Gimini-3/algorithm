import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int []arr =new int[6]; // q:1 , u:2, a:3, c:4, k:5
    public static int max=0;
    public static int swi=0;
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        String str = sca.next();
        

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            switch(ch){
                case 'q':
                    f(1);
                    break;
                case 'u':
                    f(2);
                    break;
                case 'a':
                    f(3);
                    break;
                case 'c':
                    f(4);
                    break;
                case 'k':
                    f(5);
                    break;
            }
        }
        if(swi==1){
            System.out.println("-1");
            return;
        }

        for(int i=1;i<6;i++){
            if(arr[i]!=0){
                System.out.println("-1");
                return;
            }
        }
        System.out.println(max);
        
    }

    public static void f(int x){
        if(x==1){
            if(max==arr[1]){
                max++;
                arr[1]++;
            }else{
                arr[1]++;
            }
        }else if(x==5){
            if(arr[x-1]>arr[x]){
                for(int i=1;i<5;i++){
                    arr[i]--;
                }
            }else{
                swi=1;
            }
        }else{
            if(arr[x-1]>arr[x]){
                arr[x]++;
            }else{
                swi=1;
            }
        }

        
    }
}