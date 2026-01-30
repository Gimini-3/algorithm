import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<node> list = new ArrayList<>();

        int max= -1;
        int max_idx= -1;
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            int idx= Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list.add(new node(idx,len));
            if(len>max){
                max=len;
                max_idx=idx;
            }
            
        }
        list.sort((a,b)->{
           return Integer.compare(a.idx,b.idx); 
        });
  //     System.out.println(max_idx+" "+max);

        int left = 0;
        int leftIdx = -1;
        int leftValue=0;

        long sum=0;
        while(true){    
            int nowValue=list.get(left).len;
            int nowIdx= list.get(left).idx;
    //        System.out.println(nowIdx+" "+nowValue);
            if(nowIdx==max_idx){
                sum+=(nowIdx-leftIdx)*leftValue;
                break;
            }
            if(nowValue>leftValue){
                sum+=(nowIdx-leftIdx)*leftValue;
                leftValue=nowValue;
                leftIdx= nowIdx;
            }
            
            left++;
        }

    //    System.out.println(sum);

        int right= list.size()-1;
        int rightIdx = list.get(right).idx+1;
        int rightValue=0;

        while(true){     
            int nowValue=list.get(right).len;
            int nowIdx= list.get(right).idx;
       //     System.out.println(nowIdx+" "+nowValue);
            if(nowIdx==max_idx){
                sum+=(rightIdx-nowIdx)*rightValue;
                break;
            }
            if(nowValue>rightValue){
                sum+=(rightIdx-nowIdx)*rightValue;
                rightValue=nowValue;
                rightIdx= nowIdx;
            }
            
            right--;
        }
        sum+=max;
        
        System.out.println(sum);
    }

    public static class node{
        int idx;
        int len;
        public node(int idx, int len){
            this.idx= idx;
            this.len = len;
        }
    }
}