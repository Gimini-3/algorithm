import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();

        int idx = 0;
        int idx2 = 0;
        int result = 0;

        if (str2.length() > str.length()) {
            System.out.println(0);
            return;
        }

        while (idx <= str.length() - str2.length()) {
            idx2 = 0;

            while (idx2 < str2.length() && str.charAt(idx + idx2) == str2.charAt(idx2)) {
                idx2++;
            }

            if (idx2 == str2.length()) { 
                result++;
                idx += str2.length();    
            } else {
                idx++;                
            }
        }

        System.out.println(result);
    }
}
