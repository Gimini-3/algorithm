import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<node> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            list.add(new node(x,y));
        }

        list.sort((x,y)->{
           if(x.start!=y.start){
               return Integer.compare(x.start,y.start);
           } else{
               return Integer.compare(x.end,y.end);
           }
        });

        int start= list.get(0).start;
        int end=list.get(0).end;
        int sum=0;
        for(int i=1;i<list.size();i++){
            node no= list.get(i);
            if(no.end<end){
                continue;
            }
            else if(no.start>end){
                sum+=end-start;
                start=no.start;
                end=no.end;
            }
            else {
                end=no.end;
            }
        }
        sum+=end-start;
        System.out.println(sum);
    }

    public static class node{
        int start;
        int end;
        public node(int start,int end){
            this.start = start;
            this.end= end;
        }
    }
}