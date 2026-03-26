import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[]= new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());

        Deque<node> deq= new ArrayDeque<>();
        int swi=0;
        deq.addLast(new node(start,0));
        int che[]=new int[n+1];
        che[start]=1;
        while(!deq.isEmpty()){
            node no=deq.pollFirst();
            int cnt =no.cnt;
            int x=no.x;
            
           // System.out.println(x);
            int y= arr[x];
            if((end-x)%y==0){
                cnt++;
                swi=1;
                System.out.println(cnt);
                break;
            }
            int i=1;
            while(true){              
                int nextX=x+i*y;
                if(nextX>n){
                    break;
                }
                i++;
                if(che[nextX]==1)continue;
                deq.addLast(new node(nextX,cnt+1));
                che[nextX]=1;
            }

            i=1;
            while(true){
                int nextX=x-i*y;
                if(nextX<1){
                    break;
                }
                i++;
                if(che[nextX]==1)continue;
                deq.addLast(new node(nextX,cnt+1));
                che[nextX]=1;
            }
            
        }
        if(swi==0){
            System.out.println(-1);
        }
        
    }

    public static class node{
        int x;
        int cnt;
        public node(int x, int cnt){
            this.x=x;
            this.cnt=cnt;
        }
    }
}