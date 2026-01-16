import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();
        String str = br.readLine();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                if(stack.size()==0||stack.peek()==')'){
                    stack.push(ch);
                }
                if(stack.peek()=='('){
                    stack.pop();
                }
            }else if(ch=='('){
                stack.push(ch);
            }
        }
        System.out.println(stack.size());
    }


}