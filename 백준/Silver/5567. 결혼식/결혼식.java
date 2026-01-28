import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m= Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<List<Integer>> list = new ArrayList<>(501);
        for(int i=0;i<501;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }


        Deque<node> queue = new ArrayDeque<>();
        queue.offer(new node(1,0));
        int count = 0;
        int num=0;
        int[] check= new int[501];
        check[1]=1;
        while(!queue.isEmpty()){
            
            
            node nod= queue.poll();
            if(nod.step==2)break;
            int x= nod.x;
            for(int i=0;i<list.get(x).size();i++){
                int t = list.get(x).get(i);
               // System.out.println("a "+t);
                if(check[t]==1)continue;
            //    System.out.println(t);
                num++;
                queue.offer(new node(t,nod.step+1));
                check[t]=1;
            }
            count++;
        }

    
    System.out.println(num);

    }

    public static class node{
        int x;
        int step;
        public node(int x,int step){
            this.x = x;
            this.step = step;
        }
    }
}