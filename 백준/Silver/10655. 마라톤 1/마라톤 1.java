import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int beforeX= Integer.parseInt(st.nextToken());
        int beforeY= Integer.parseInt(st.nextToken());
        List<node> list = new ArrayList<>();
        list.add(new node(beforeX,beforeY));
        int sum= 0;
        for(int i=1;i<n;i++){
            st= new StringTokenizer(br.readLine());
            int X= Integer.parseInt(st.nextToken());
            int Y= Integer.parseInt(st.nextToken());
            sum+=Math.abs(beforeX-X)+ Math.abs(beforeY-Y);
            list.add(new node(X,Y));
            beforeX=X;
            beforeY=Y;
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            node now = list.get(i);
            node before = list.get(i-1);
            node after = list.get(i+1);
            int sum2= sum;
            sum2-=(Math.abs(now.x-before.x)+Math.abs(now.y-before.y));
            sum2-=(Math.abs(now.x-after.x)+Math.abs(now.y-after.y));
            sum2+=(Math.abs(after.x-before.x)+Math.abs(after.y-before.y));
            min= Math.min(sum2,min);
        }
        System.out.println(min);
    
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