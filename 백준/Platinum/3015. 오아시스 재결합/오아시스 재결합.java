import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[500001];
        Pair []stack = new Pair[500001];
        int top=-1;
        for(int i=0;i<n;i++){
            long x= Long.parseLong(br.readLine());
            arr[i]=x;
        }
       // System.out.println((long)1<<31);
        stack[++top]= new Pair(1,arr[n-1]);
        long count=0;
        for(int i=n-2;i>=0;i--){
            long value = arr[i];
            
            int stop = 0;
            int swi= 0;
            while(true){
                if(top<0){
                    if(swi==1){
                        top=stop;
                    }
                    break;
                }
                Pair p= stack[top];
                long topValue = p.value;
                int topDup = p.dup;
                if(value<topValue){
                    count++;
                    if(swi==1){
                        top=stop;
                    }
                    break;
                }else if(value==topValue){
                    if(swi==0){
                        stop=top;
                        swi=1;
                    }
                    count+=(topDup);
                    p.dup+=1;
                    top--;
                }else if(value>topValue){
                    count+=topDup;
                    top--;
                }
            }
            if(swi==0)stack[++top]=new Pair(1,value);
          //  System.out.print("count: "+count+"   ");
          //  for(int j=0;j<=top;j++){
         //       System.out.print("("+stack[j].value+","+stack[j].dup+")");
         //   }System.out.println();
            
        } 
        System.out.println(count);
    }

    public static class Pair{
        int dup;
        long value;
        public Pair(int dup,long value){
            this.dup = dup;
            this.value = value;
        }
    }
}