import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(br.readLine());
        }
        int che=0;
        int idx=0;
        int arr[]=new int[str.length()];
        for(int i=0;i<str.length();i++){
            if(i!=0&&arr[i-1]==0)continue;
            for(int j=i+1;j<=str.length();j++){
                String s= str.substring(i,j);
        //        System.out.printf("i:%d j:%d s:%s\n",i,j,s);
                if(set.contains(s)){
                    arr[j-1]=1;
                }
            }
        }
        if(arr[str.length()-1]==1){
            System.out.println("1");
        }else{
            System.out.println("0");
            
        }
    }

 
}