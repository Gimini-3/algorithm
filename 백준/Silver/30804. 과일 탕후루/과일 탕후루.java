import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[10];
        int distinct = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            if (cnt[arr[right]]++ == 0) distinct++;

            while (distinct > 2) {
                if (--cnt[arr[left]] == 0) distinct--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }
}