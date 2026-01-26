import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        final int INF = 1_000_000_000;

        // dir: 0=왼쪽아래, 1=아래, 2=오른쪽아래
        int[][] prev = new int[m][3];
        int[][] cur = new int[m][3];

        for (int j = 0; j < m; j++) {
            prev[j][0] = a[0][j];
            prev[j][1] = a[0][j];
            prev[j][2] = a[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) Arrays.fill(cur[j], INF);

            for (int j = 0; j < m; j++) {
                int cost = a[i][j];

                if (j + 1 < m) {
                    cur[j][0] = cost + Math.min(prev[j + 1][1], prev[j + 1][2]);
                }

                cur[j][1] = cost + Math.min(prev[j][0], prev[j][2]);

                if (j - 1 >= 0) {
                    cur[j][2] = cost + Math.min(prev[j - 1][0], prev[j - 1][1]);
                }
            }

            int[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        int ans = INF;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, prev[j][0]);
            ans = Math.min(ans, prev[j][1]);
            ans = Math.min(ans, prev[j][2]);
        }

        System.out.println(ans);
    }
}