import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        int  y=sc.nextInt();
        int z=sc.nextInt();

        double v1 = (double)x *(double)y / (double)z;
        double v2=  (double)x /(double)y * (double)z;
    
        
        if(v1>v2){
            System.out.println((int)v1);
        }else{
        System.out.println((int)v2);
                
        }
    }


}