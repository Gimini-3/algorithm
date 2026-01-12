import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int S;
    public static int[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        S=Integer.parseInt(br.readLine());
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1,0,0));
        check= new int[2002][2002];
        while(!queue.isEmpty()){
             Pair p = queue.poll();
            int screen= p.screen;
            int clip= p.clip;
            int time=p.time;
       //     System.out.printf("screen:%d clip:%d time:%d\n",screen,clip,time);

            if(screen+clip==S||screen-1==S){
                System.out.println(time+1);
                break;
            }
            if(screen+clip<=S&&check[screen+clip][clip]==0){
                check[screen+clip][clip]=1;
                queue.add(new Pair(screen+clip,clip,time+1));
            }
            if(check[screen][screen]==0){
                check[screen][screen]=1;
                queue.add(new Pair(screen,screen,time+1));
            }
            if(screen-1>=0&&check[screen-1][clip]==0){
                check[screen-1][clip]=1;
                queue.add(new Pair(screen-1,clip,time+1));
            }           
        }
    }
  

    public static class Pair{
        public int screen;
        public int clip;
        public int time;
        public Pair(int screen,int clip,int time){
            this.screen = screen;
            this.clip=clip;
            this.time = time;
        }
    }
}