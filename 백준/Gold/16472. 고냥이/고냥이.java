import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  
        String str = br.readLine();
        int len = str.length();

        int[] cnt = new int[26];  
        int left = 0;
        int che = 0;              
        int max = 0;

        for (int right = 0; right < len; right++) {
            int r = str.charAt(right) - 'a';

            
            cnt[r]++;
            if (cnt[r] == 1) che++;   

            
            while (che > n) {
                int l = str.charAt(left) - 'a';
                cnt[l]--;
                if (cnt[l] == 0) che--;  
                left++;
            }

            int cur = right - left + 1;
            if (cur > max) max = cur;
        }

        System.out.println(max);
    }
}