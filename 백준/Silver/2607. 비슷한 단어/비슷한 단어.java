import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int []arr= new int[130]; //아스키코드 숫자용
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            arr[ch]++;
        }
        int []arr2= new int[130];
        int result=0;
        for(int i=0;i<n-1;i++){
            int diff=0;
            for(int j=(int)'A';j<=(int)'Z';j++){
                arr2[j]=0;
            }
            String str2 = br.readLine();
           // System.out.println(str2);
            for(int j=0;j<str2.length();j++){
                arr2[str2.charAt(j)]++;
            }

            for(int j=(int)'A';j<=(int)'Z';j++){
                diff+=Math.abs(arr2[j]-arr[j]);
            }
            if(diff==1||diff==0){
                result++;
            }else if(diff==2){
                if(str.length()==str2.length()){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}