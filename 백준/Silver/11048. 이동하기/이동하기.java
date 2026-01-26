import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    max[i][j] = a[i][j];
                    continue;
                }

                int best = -1;
                if (i > 1) best = Math.max(best, max[i - 1][j]);       // 위에서 옴
                if (j > 1) best = Math.max(best, max[i][j - 1]);       // 왼쪽에서 옴
                if (i > 1 && j > 1) best = Math.max(best, max[i - 1][j - 1]); // 대각에서 옴

                max[i][j] = best + a[i][j];
            }
        }

        System.out.println(max[n][m]);
    }
}
