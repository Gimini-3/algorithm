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

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<n-1;i++){
            int x=  Integer.parseInt(st.nextToken());
            if(x>m)list.add(i);
        }
        //for(int i=0;i<list.size();i++){
       //     System.out.print(list.get(i)+" ");
       // }
        int max=0;
        if(list.size()==1||list.size()==0){
            System.out.println(n);
            return;
        }else if(list.size()==2){
            int x =list.get(0);
            int y =list.get(1);
            int t= y+1;
            int q=n-x-1;
        //    System.out.println(t);
        //    System.out.println(q);
            max=Math.max(t,max);
            max=Math.max(q,max);
            System.out.println(max);
            return;
        }
        max= Math.max(list.get(1)+1,max);
        for(int i=2;i<list.size();i++){
            int x =list.get(i-2);
            int y =list.get(i);
            max=Math.max(y-x,max);
        }
        System.out.println(max);
    }

 

}