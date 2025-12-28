import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    //0 -> h
    //1 -> w
    //2 -> e
    //3 -> o
    //4 -> l
    //5 -> r
    //6 -> d
    public static int[] arr= new int[7];
    public static boolean[] check = new boolean[10];
    public static int N;
    public static boolean swi= false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        f(0);
        if(!swi)System.out.println("No Answer");
    }

    public static void f(int x){
        if(x==7){
            int sum = 10000*arr[0]+1000*arr[2]+100*arr[4]+10*2*arr[4]+1*arr[3]+10000*arr[1]+1000*arr[3]+100*arr[5]+1*arr[6];
           // System.out.println("sum"+sum);
            if(sum==N){
                System.out.println("  "+Integer.toString(arr[0])+Integer.toString(arr[2])+Integer.toString(arr[4])+Integer.toString(arr[4])+Integer.toString(arr[3]));
                System.out.println("+ "+Integer.toString(arr[1])+Integer.toString(arr[3])+Integer.toString(arr[5])+Integer.toString(arr[4])+Integer.toString(arr[6]));
                System.out.println("-------");
                String str = Integer.toString(N);
                if(str.length()==6){
                    System.out.println(" "+str);
                }
                else if(str.length()==5){
                    System.out.println("  "+str);
                }
                swi=true;
            }
            return;
        }
        for(int i=0;i<10;i++){
            if(i==0&&(x==0||x==1))continue;
            if(check[i])continue;
            arr[x]=i;
            check[i]=true;
         //   System.out.println("x:"+x+"i:"+i);
            f(x+1);
            check[i]=false;
            if(swi)return;
        }
    
    }
}