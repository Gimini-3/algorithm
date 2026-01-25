import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<node> list =  new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new node(start,end));
        }
        int []arr = new int[366];
        list.sort((x,y)->{
            if(x.start==y.start){
                return Integer.compare(y.end,x.end);
            }else{
                return Integer.compare(x.start,y.start);
            }
        });
        int now_length=0;
        int now_start=-1;
        int now_end=-1;
        int sum=0;
        for(int i=0;i<list.size();i++){
            int start= list.get(i).start;
            int end = list.get(i).end;
         //   System.out.println(start+" "+end);
            if(start>now_end+1){
                int width = now_end-now_start+1;
                sum+=width*now_length;
                now_start=start;
                now_end=end;
                now_length=0;
         //      System.out.println(+now_start+" "+ now_end+" " +sum);
            }
           else{
                now_end= Math.max(now_end,end);
            }
            for(int j=start;j<=end;j++){
                    arr[j]++;
                    now_length = Math.max(now_length,arr[j]);
                }
        }
       // System.out.println(now_start+" "+now_end);
    //    for(int i=0;i<100;i++){
    //        System.out.print(arr[i]+" ");
     //   }System.out.println();
        sum+=(now_end-now_start+1)*now_length;
        System.out.println(sum);
    }

    public static class node{
        public int start;
        public int end;
        public node(int start,int end){
            this.start = start;
            this.end = end;
            
        }
    }
}