import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            if(str.startsWith("push")){
                int t = str.lastIndexOf(" ");
                //System.out.println(str.substring(t+1));
                int m=Integer.parseInt(str.substring(t+1));
            //    System.out.println(m);
                stack.push(m);
            }else if(str.equals("top")){
                 if(stack.size()==0){
                    sb.append(-1).append('\n');
                    
                }else{
                    int a= stack.peek();
                    sb.append(a).append('\n');
                    
                }
            }else if(str.equals("pop")){
                if(stack.size()==0){
                    sb.append(-1).append('\n');
                    
                }else{
                    int a= stack.pop();
                    sb.append(a).append('\n');
                    
                }
                    
            }else if(str.equals("size")){
                    sb.append(stack.size()).append('\n');
                
            }else if(str.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1).append('\n');
                }else {
                    sb.append(0).append('\n');
                }
            }
            
        }
        System.out.println(sb);
    }
}