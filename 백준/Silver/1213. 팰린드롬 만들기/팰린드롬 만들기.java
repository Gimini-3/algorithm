import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static StringBuilder sb;
    public static String str;
    public static int odd_idx;
    public static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        // 0:a 1:b 2:c 3:d 4:e 5
        arr =new int[26];
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int x= c-'A';
        //    System.out.println(x);
            arr[x]++;
        }

        sb = new StringBuilder();
        int num=0;
        odd_idx=-1;
        for(int i=0;i<26;i++){
            if(arr[i]%2==1){
                num++;
                odd_idx=i;
            }
        }
        if(str.length()%2==0&&num>0){
            System.out.println("I'm Sorry Hansoo");
            return;
            
        }if(str.length()%2==1&&num>1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        f(0);
        System.out.println(sb);
    }

    public static void f(int idx){
        if(idx>25){
            if(str.length()%2==1){
                sb.append((char)(odd_idx+'A'));
            }
            return;
        }
        for(int i=1;i<=arr[idx]/2;i++){
        //    System.out.println((char)(idx+'A'));
            sb.append((char)(idx+'A'));
        }
        f(idx+1);
        for(int i=1;i<=arr[idx]/2;i++){
        //    System.out.println((char)(idx+'A'));
            sb.append((char)(idx+'A'));
        }
    }
}