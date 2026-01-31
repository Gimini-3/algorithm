import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long sum = 0;
        int arr[] = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            arr[i] = x;
            if (x > max) max = x;
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long num = 0;
            for (int i = 0; i < arr.length; i++) {
                num += arr[i] / mid;
            }

            if (num < m) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        long answer = sum - (long) m * result;
        System.out.println(answer);
    }
}