import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Deque<Integer> stack1  = new ArrayDeque<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                int x = stack1.pop();
                int y = stack1.pop();
                int t=0;
                switch(ch){
                case '+':
                    t= x+y;
                    break;
                case '-':
                    t= y-x;
                    break;
                case '*':
                    t=x*y;
                    break;
                case '/':
                    t=y/x;
                    break;
                }
                stack1.push(t);
            }else{
                 stack1.push((int)(str.charAt(i)-'0'));
            }
        
        }
        
       
        System.out.println(stack1.pop());
        
    }
}