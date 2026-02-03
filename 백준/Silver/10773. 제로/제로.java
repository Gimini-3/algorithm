import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int x= Integer.parseInt(br.readLine());
            if(x==0){
                stack.pop();
            }else{
                stack.push(x);
            }
        }
        long sum=0;
        for(int i:stack){
            int x= stack.pop();
            sum+=x;
            
        }
        System.out.println(sum);
    }
}