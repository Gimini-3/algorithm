import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t=0;t<n;t++){
            String str =br.readLine();
            Deque<Character> deque1= new ArrayDeque<>();
            Deque<Character> deque2 =  new ArrayDeque<>();
            for(int i=0;i<str.length();i++){
                char c= str.charAt(i);
                if(c=='<'){
                    if(deque1.size()==0)continue;
                    char ch = deque1.pop();
                    deque2.push(ch);
                }else if(c=='>'){
                    if(deque2.size()==0)continue;
                    char ch = deque2.pop();
                    deque1.push(ch);
                }else if(c=='-'){
                    if(deque1.size()==0)continue;
                    deque1.pop();
                }else{
                    deque1.push(c);
                }
            }
            for(Character ch: deque2){
                deque1.push(ch);
            }
            StringBuilder sb= new StringBuilder();
            while(!deque1.isEmpty()){
                sb.append(deque1.removeLast());
            }System.out.println(sb);
        }
    }
}