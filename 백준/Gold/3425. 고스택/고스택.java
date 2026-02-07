import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static Deque<Integer> sta; 
    public static int swi=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        while(true){

            List<node> list = new ArrayList<>();
        
            while(true){
                String s= br.readLine();
                if(s.equals("QUIT")){
                    System.out.println(sb);
                    return;
                }
                if(s.equals("END"))break;
                String[] spl= s.split(" ");
                if(spl.length==1){
                    list.add(new node(spl[0],-1));
                }
                else list.add(new node(spl[0],Integer.parseInt(spl[1])));
            }
            int n =Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                int x= Integer.parseInt(br.readLine());
                sta = new ArrayDeque<>();
                sta.push(x);
                for(int j=0;j<list.size();j++){
                    node no= list.get(j);
                    f(no.str,no.x);
                    if(swi==1)break;
                }
                if(swi==1){
                    sb.append("ERROR").append("\n");
                    swi=0;
                }else if(sta.size()!=1){
                    sb.append("ERROR").append("\n");
                }else{
                    sb.append(sta.pop()).append("\n");
                }
            }

            br.readLine();
            sb.append("\n");
            
        }
    }

    public static void f(String str,int x){
        switch(str){
            case "NUM":
                NUM(x);
                break;
            case "POP":
                POP();
                break;
            case "INV":
                INV();
                break;
            case "DUP":
                DUP();
                break;
            case "SWP":
                SWP();
                break;
            case "ADD":
                ADD();
                break;
            case "SUB":
                SUB();
                break;
            case "MUL":
                MUL();
                break;
            case "DIV":
                DIV();
                break;
            case "MOD":
                MOD();
                break;
        }
    }

    public static void NUM(int x){
        sta.push(x);
    }
    public static void POP(){
        if(sta.isEmpty()){
            swi=1;
            return;
        }
        sta.pop();
    }
    public static void INV(){
        if(sta.isEmpty()){
            swi=1;
            return;
        }
        int x= sta.pop();
        x= -x;
        sta.push(x);
    }
    public static void DUP(){
        if(sta.isEmpty()){
            swi=1;
            return;
        }
        int x= sta.peek();
        sta.push(x);
    }
    public static void SWP(){
        if(sta.size()<2){
            swi=1;
            return;
        }
        int x = sta.pop();
        int y = sta.pop();
        sta.push(x);
        sta.push(y);
    }
    public static void ADD(){
        if(sta.size()<2){
            swi=1;
            return;
        }
        int x= sta.pop();
        int y= sta.pop();
     //   System.out.println(x+" "+y);
        long sum = (long)x+(long)y;
        if(Math.abs(sum)>1000000000){
     //       System.out.println("ADD_ERROR");
            
            swi=1;
            return;
        }
        sta.push((int)sum);
    }
    public static void SUB(){
        if(sta.size()<2){
            swi=1;
            return;
        }
        int x= sta.pop();
        int y = sta.pop();
        long sum=(long)y-(long)x;
        if(Math.abs(sum)>1000000000){
            swi=1;
            return;
        }
       // System.out.println(sum);
        sta.push((int)sum);
    }
    public static void MUL(){
        if(sta.size()<2){
            swi=1;
            return;
        }
        int x= sta.pop();
        int y = sta.pop();
        long sum=(long)y*(long)x;
        if(Math.abs(sum)>1000000000){
            swi=1;
            return;
        }
        sta.push((int)sum);
    }
    public static void DIV(){
        if(sta.size()<2){
            swi=1;
            return;
        }
        int x= sta.pop();
        int y = sta.pop();
        if(x==0){
            swi=1;
            return;
        }
        int sum=Math.abs(y)/Math.abs(x);
        if((y<0&&x>0)||(y>0&&x<0)){
            sum=-sum;
        }
        sta.push(sum);
        
    }
    public static void MOD(){
        if(sta.size()<2){
            swi=1;
            return;
        }
        int x= sta.pop();
        int y = sta.pop();
        if(x==0){
            swi=1;
            return;
        }
        int sum=Math.abs(y)%Math.abs(x);
        if(y<0){
            sum=-sum;
        }
        sta.push(sum);
    }
    public static class node{
        String str;
        int x;
        public node(String str, int x){
            this.str = str;
            this.x=  x;
        }
    }
}