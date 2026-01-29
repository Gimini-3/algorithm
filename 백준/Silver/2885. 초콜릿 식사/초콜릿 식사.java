import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n= sca.nextInt();
 
        int size=0;
        for(int i=0;i<100;i++){
            int x= 1<<i;
            if(x>=n){
                size=x;
                break;
            }
        }
       // System.out.println(size);

        int size2= size;
        int sum=n;
        int count=0;
        while(true){
            if(size2>sum){
                size2/=2;
                count++;
            }else if(size2==sum){
                break;
            }else{
                sum-=size2;
            }
        }
        System.out.println(size+" "+count);
    }
}