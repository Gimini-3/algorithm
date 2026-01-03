import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n5 = n/5;
        for(int i=n5;i>=0;i--){
            int a = n-i*5;
            if(a%3==0){
                System.out.println(i+a/3);
                return;
            }
            
        }
        System.out.println("-1");
    }
    
}