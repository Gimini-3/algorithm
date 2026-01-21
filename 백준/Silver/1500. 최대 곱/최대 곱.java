import java.util.*;
import java.io.*;

class Main {
    public static long max = 0L;
    public static long mul = 1L;
    public static int m;
    public static int n;
    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sum = 0;
        f(0, 1);
        System.out.println(max);
    }

    public static void f(int idx, int start) {
        if (sum > n) return;

        if (idx == m) {
            if (sum == n) max = Math.max(max, mul);
            return;
        }

        int remain = m - idx;                 
        int u = (n - sum) / remain;         

        if (u < start) return;            

        for (int i = start; i <= u; i++) {
            mul *= i;
            sum += i;
            f(idx + 1, i);           
            sum -= i;
            mul /= i;
        }
    }
}