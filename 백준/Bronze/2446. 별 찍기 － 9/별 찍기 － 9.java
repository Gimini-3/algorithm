import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw =new BufferedWriter(new OutputStreamWriter(System.out));
        N =Integer.parseInt(br.readLine());
        f(N);
        bw.flush();
        bw.close();
    }

    public static void f(int x) throws IOException{
        if(x==1){
            int a= N-x;
            
            for(int i=0;i<a;i++)bw.write(" ");
            for(int i=0;i<2*x-1;i++)bw.write("*");
            bw.newLine();
            return;
        }
        int a= N-x;
        for(int i=0;i<a;i++)bw.write(" ");
        for(int i=0;i<2*x-1;i++)bw.write("*");
        bw.newLine();
        f(x-1);
        for(int i=0;i<a;i++)bw.write(" ");
        for(int i=0;i<2*x-1;i++)bw.write("*");
        if(x==N)return;
        bw.newLine();
    }
}