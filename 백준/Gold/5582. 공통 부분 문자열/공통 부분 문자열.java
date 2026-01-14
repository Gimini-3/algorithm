import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();
        int[][]arr = new int[str.length()+1][str2.length()+1];

        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str.charAt(i-1)==str2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                }
            }
        }
        int max = 0;
        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=str2.length();j++){
                max= Math.max(max,arr[i][j]);
            }
        }
        System.out.println(max);
    }
}