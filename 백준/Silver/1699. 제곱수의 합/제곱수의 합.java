import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악: 1^2을 i번
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
