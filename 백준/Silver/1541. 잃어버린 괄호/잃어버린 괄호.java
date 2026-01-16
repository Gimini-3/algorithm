import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] spl = str.split("-");
        int[] arr = new int[spl.length];
        for(int i=0;i<spl.length;i++){
           // System.out.println(spl[i]);
            String[] spl2 = spl[i].split("\\+");
            int sum=0;
            for(int j=0;j<spl2.length;j++){
                int idx = firstNonZeroIndex(spl2[j]);
                spl2[j]= spl2[j].substring(idx);
               // System.out.println(spl2[j]);
                sum+=Integer.parseInt(spl2[j]);
            }
          //  System.out.println(sum);
            arr[i]=sum;
        }
        int result=arr[0];
        for(int i=1;i<arr.length;i++){
            result-=arr[i];
        }
        System.out.println(result);
        
     
    }

    public static int firstNonZeroIndex(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                return i;
            }
        }
        // 모두 0일 때
        return 0;
    }
}