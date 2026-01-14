import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static String str;
    public static int len;
    public static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
      //  System.out.println(str);
        len = str.length();
     //   System.out.println(len);
        
        arr=new int[len];
        Stack<Pair> sta = new Stack<>();
        sta.push(new Pair(str.charAt(0),0));
        for(int i=1;i<len;i++){
            char now = str.charAt(i);
            if(sta.isEmpty()){
                sta.push(new Pair(now,i));
                continue;
            }
            Pair p = sta.peek();
            if((now==')'&&p.value=='(')||now==']'&&p.value=='['){
       //     System.out.println(sta.size()+" "+p.value+" "+now);
                sta.pop();
                arr[i]=p.idx;
                arr[p.idx]=i;
                continue;
            }
            sta.push(new Pair(now,i));
        }
  //      System.out.println(sta.size());
    //   for(int i=0;i<len;i++){
    //        System.out.print(arr[i]+" ");
   //     }System.out.println();
        
        if(!sta.isEmpty()){
            System.out.println(0);
            return;
        }

        int left = 0;
        int result = 0;
        int right = arr[left];
        while(true){
            result+=f(left,right);
            if(right+1==len){
                break;
            }
            left=right+1;
            right=arr[left];
        }
       
        System.out.println(result);
    }

    public static int f(int start, int end){
    //    System.out.println(start+" "+end);
        if(end-start==1){
            return (str.charAt(start)=='(')?2:3;
        }
        int left=start+1;
        int right= arr[left];
        int sum=0;
        while(true){
            sum+=f(left,right);
            if(right+1==end){
                break;
            }
            left=right+1;
            right= arr[left];
        }
        
        if(str.charAt(start)=='('){
                return 2*sum;
            }else if(str.charAt(start)=='['){
                return 3*sum;
        }
        return -1;
    }

    public static class Pair{
        public char value;
        public int idx;
        public Pair(char value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
}