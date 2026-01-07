import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        while(true){
            int x = Integer.parseInt(br.readLine());
     //       System.out.print(x+" ");
            if(x==-1)break;
            else if(x==0){
                int t= queue.poll();
               // System.out.println("큐에서 꺼냄 t:"+t);
            }
            else{
                if(queue.size()==n){
             //   System.out.println("꽉 찼음");
                continue;
               }
             //   System.out.println("큐에 넣음 x:"+x);
                queue.add(x);
            }
            
        }
        if(queue.size()==0){
            System.out.println("empty");
        }
        StringBuilder sb =new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb);
    }
}