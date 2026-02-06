import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n+m;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            map.put(x,y);
        }
        int []che = new int[101];

        Deque<node> queue = new ArrayDeque<>();
        queue.offer(new node(1,0));
        che[1]=1;
        while(true){
            node nod= queue.poll();
           // System.out.println(nod.x+" "+nod.lev);
            
                for(int i=1;i<=6;i++){
                    int nextX= nod.x+i;
                    int nextLev= nod.lev+1;
                    
                    if(nextX>100){
                        continue;
                    }else if(nextX==100){
                        System.out.println(nextLev);
                        return;
                    }
                    if(che[nextX]==1)continue;
                    che[nextX]=1;
                    if(map.get(nextX)!=null){
                        nextX = map.get(nextX);
                        che[nextX]=1;
                        queue.offer(new node(nextX,nextLev));
                    }
                    else queue.offer(new node(nextX,nextLev));
                }

            
        }
    }

    public static class node{
        int x;
        int lev;
        public node(int x,int lev){
            this.x=x;
            this.lev=lev;
        }
    }
}