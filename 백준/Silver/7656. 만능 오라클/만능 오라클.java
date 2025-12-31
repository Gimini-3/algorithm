import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

     public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         String str = br.readLine();
         int idx= 0;
         while(true){
             if(idx>=str.length()){
                 break;
             }
       //      System.out.println(idx);
             char x= str.charAt(idx);
             if('A'<=x&&x<='Z'){
               //  System.out.println(str.substring(idx,idx+7));
                 if(str.substring(idx,idx+7).equals("What is")){
                 //    System.out.println("start: "+idx);
                     int start = idx;
                     while(true){
                         idx++;
                         if(str.charAt(idx)=='.'){
                     //        System.out.println(".: "+idx);
                             
                             break;
                         }else if(str.charAt(idx)=='?'){
                         //    System.out.println("?: "+idx);
                             String str2= str.substring(start+4,idx);
                             String result = "Forty-two"+str2+".";
                         //    System.out.println(result);
                             bw.write(result);
                             bw.newLine();
                             break;
                         }
                     }
                 } // What is 추출
                 idx++;
             }else{
                 idx++;
             }
         }
         bw.flush();
         bw.close();
     }
}