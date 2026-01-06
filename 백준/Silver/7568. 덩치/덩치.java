import java.io.*;
import java.util.*;

class Main {
    static class Pair {
        int wei, hei;
        Pair(int w, int h) { wei = w; hei = h; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            a[i] = new Pair(w, h);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (a[j].wei > a[i].wei && a[j].hei > a[i].hei) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }

        System.out.print(sb);
    }
}