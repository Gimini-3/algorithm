import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) dq.addLast(i);

        st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            // target의 현재 위치(pos) 찾기
            int pos = 0;
            for (int v : dq) {
                if (v == target) break;
                pos++;
            }

            int size = dq.size();
            int left = pos;          // 왼쪽 회전 횟수
            int right = size - pos;  // 오른쪽 회전 횟수

            if (left <= right) {
                for (int k = 0; k < left; k++) {
                    dq.addLast(dq.pollFirst()); // 왼쪽 회전
                }
                result += left;
            } else {
                for (int k = 0; k < right; k++) {
                    dq.addFirst(dq.pollLast()); // 오른쪽 회전
                }
                result += right;
            }

            dq.pollFirst(); // target 제거
        }

        System.out.println(result);
    }
}