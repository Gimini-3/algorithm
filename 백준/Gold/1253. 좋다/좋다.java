import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        Arrays.sort(a);

        int good = 0;

        for (int k = 0; k < n; k++) {
            int l = 0, r = n - 1;
            long target = a[k];

            while (l < r) {
                if (l == k) { l++; continue; }
                if (r == k) { r--; continue; }

                long sum = a[l] + a[r];

                if (sum == target) {
                    good++;
                    break;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.println(good);
    }
}