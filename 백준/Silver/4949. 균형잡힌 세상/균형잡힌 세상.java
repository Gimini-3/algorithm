import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals(".")){
                return;
            }
            boolean balance = true;
            Stack<Character> queue = new Stack<>();
            for(int i=0;i<str.length();i++){
                char c= str.charAt(i);
                if(c=='.')break;
                if(c=='('||c=='['){
                 //   System.out.print(" in:"+c);
                    queue.push(c);
                }else if(c==')'){
                    if(queue.isEmpty()){
                        balance=false;
                        break;
                    }
                    char x= queue.pop();
               //     System.out.print(" out:"+x);
                    
                    if(x!='('){
                        balance=false;
                        break;
                    }
                }else if(c==']'){
                    if(queue.isEmpty()){
                        balance=false;
                        break;
                    }
                    char x = queue.pop();
                 //   System.out.print(" out:"+x);
                    
                    if(x!='['){
                        balance=false;
                        break;
                    }
                }
                
            }
            if(!queue.isEmpty()){
                balance=false;
            }
            if(balance){
                System.out.println("yes"); 
            }else{
                System.out.println("no");
            }
        }

        
    }
}

 