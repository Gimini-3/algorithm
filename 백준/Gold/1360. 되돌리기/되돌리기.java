import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<node> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String str= st.nextToken();
            int t=-1;
            if(str.equals("type"))  t= st.nextToken().charAt(0);
            else t= Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());
            
            list.add(new node(str,t,now));
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int ign = Integer.MAX_VALUE;
        for(int i=list.size()-1;i>=0;i--){
            node nod = list.get(i);
            String str =nod.str;
            int t= nod.t;
            int now= nod.now;
            if(now>=ign){
         //       System.out.println("pass"+now);
                continue;
            }
            if(str.equals("undo")){
                
                ign=now-t;
                
            //    System.out.println("ign:"+ign);
            }else if (str.equals("type")){
                stack.push(t);
            }
        }
        StringBuilder sb= new StringBuilder();
     //   System.out.println(stack.size());
        while(!stack.isEmpty()){
            int x= stack.pop();
            char ch = (char)x;
        //    System.out.println(ch);
            sb.append(String.valueOf(ch));
        }
        System.out.println(sb);
    }

    public static class node{
        String str;
        int t;
        int now;

        public node(String str, int t, int now){
            this.str=str;
            this.t=t;
            this.now=now;
        }
    }



    
}