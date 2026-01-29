import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S= br.readLine().split(" ");
        int n= Integer.parseInt(S[0]);
        int k= Integer.parseInt(S[1]);
        String str = br.readLine();

        int sum=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='H'){
                pq.offer(i);
            }else if(str.charAt(i)=='P'){
                list.add(i);
                
            }
        }
        for(int i=0;i<list.size();i++){
            int p = list.get(i);
            while(!pq.isEmpty()){
                    int x= pq.peek();
             //       System.out.printf("p:%d x:%d\n",p,x);
                    if(p>x&&p-x>k){
                        pq.poll();
                        continue;
                    }
                    else if(p<x&&x-p>k){
                        break;
                    }
                    pq.poll();
             //       System.out.printf("213123p:%d x:%d\n",p,x);
                    sum++;
                    break;
            }
        }
        
        System.out.println(sum);
        
    }
    

    public static class node{
        int x;
        int y;
        public node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}