import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int j=0;j<n;j++){
            String str = br.readLine();
            Deque<Character> sta = new ArrayDeque<>();
            int swi=0;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(c==')'){
                    if(sta.size()<1){
                        swi=1;
                        break;
                    }
                    if(sta.pop()==')'){
                        swi=1;
                        break;
                    }
                }else if(c=='('){
                    sta.push(c);
                }
            }
            if(sta.size()==0&&swi==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
                
            }
        }
        
    }
}