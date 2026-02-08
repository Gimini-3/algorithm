import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sca = new Scanner(System.in);
        int t= sca.nextInt();
        Long arr[]= new Long[101];
        arr[1]=1l;
        arr[2]=1l;
        arr[3]=1l;
        arr[4]=2l;
        arr[5]=2l;
        
        for(int i=6;i<=100;i++){
            arr[i]=arr[i-5]+arr[i-1];
        }
        
        for(int i=0;i<t;i++){
            System.out.println(arr[sca.nextInt()]);
        }
        
    }
}