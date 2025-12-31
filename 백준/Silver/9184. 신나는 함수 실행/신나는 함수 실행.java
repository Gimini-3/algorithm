import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static long[][][] arr= new long[51][51][51];
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1&&c==-1){
                bw.flush();
                bw.close();
                return;
            }
            long result = w(a,b,c); 
     //       System.out.println(result);
            bw.write("w("+a+", "+b+", "+c+") = "+result);
            bw.newLine();
            
            
        }
    }

    public static long w(int a,int b, int c){
         if(a<=0||b<=0||c<=0){
             
            return 1;
        }
       // System.out.println("a: "+a+"b: "+b+"c: "+c);
        if(arr[a][b][c]!=0){
   //         System.out.println("a: "+a+" b: "+b+" c: "+c+" w():"+arr[a][b][c]);
            return arr[a][b][c];
        }

        else if(a>20||b>20||c>20){
            arr[a][b][c]= w(20,20,20);
            return arr[a][b][c];
        }
        else if(a<b&&b<c){
            arr[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)- w(a,b-1,c);
            return arr[a][b][c];
        }else{
            arr[a][b][c]=w(a-1,b,c)+ w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
            return arr[a][b][c];
        }
    }
}