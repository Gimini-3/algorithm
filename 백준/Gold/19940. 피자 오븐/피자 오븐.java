import java.util.*;
import java.io.*;

class Main {
    public static int[] dist;
    public static int[][] best;
    public static int[] dx = { 60, 10, -10, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dist = new int[61];
        for (int i = 0; i < dist.length; i++) dist[i] = 61;

        best = new int[61][5];

        Queue<pair> queue = new ArrayDeque<>();

        dist[0] = 0;
        queue.add(new pair(0, 0));

        while (!queue.isEmpty()) {
            pair p = queue.poll();
            int x = p.x;

            int time = dist[x] + 1;

            for (int i = 0; i < 5; i++) {
                int nextX = x + dx[i];

                if (nextX < 0) nextX = 0;
                if (nextX > 60) continue;

                int[] cand = new int[5];
                for (int j = 0; j < 5; j++) cand[j] = best[x][j];
                cand[i]++;

                //  더 짧거나, 같은 거리면 사전순 더 좋은 경우 갱신
                if (time < dist[nextX] || (time == dist[nextX] && lexBetter(cand, best[nextX]))) {
                    dist[nextX] = time;
                    for (int j = 0; j < 5; j++) best[nextX][j] = cand[j];

                    queue.add(new pair(time, nextX));
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            int a = t / 60;
            int b = t % 60;

            sb.append(best[b][0] + a).append(' ')
              .append(best[b][1]).append(' ')
              .append(best[b][2]).append(' ')
              .append(best[b][3]).append(' ')
              .append(best[b][4]).append('\n');
        }

        System.out.print(sb);
    }

    // 사전순: ADDH → ADDT → MINT → ADDO → MINO 
    static boolean lexBetter(int[] cand, int[] cur) {
        for (int i = 0; i < 5; i++) {
            if (cand[i] != cur[i]) return cand[i] < cur[i];
        }
        return false;
    }

    public static class pair {
        public int time;
        public int x;
        public pair(int time, int x) {
            this.time = time;
            this.x = x;
        }
    }
}
