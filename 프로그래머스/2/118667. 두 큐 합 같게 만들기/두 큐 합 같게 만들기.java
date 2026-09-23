import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Long> dq1 = new ArrayDeque<>();
        Deque<Long> dq2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int x : queue1) {
            dq1.addLast((long) x);
            sum1 += x;
        }

        for (int x : queue2) {
            dq2.addLast((long) x);
            sum2 += x;
        }

        // 전체 합이 홀수면 절대 같은 합을 만들 수 없음
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        int turn = 0;
        int limit = (queue1.length + queue2.length) * 2;

        while (turn <= limit) {

            if (sum1 == sum2) {
                return turn;
            }

            if (sum1 > sum2) {
                if (dq1.isEmpty()) {
                    return -1;
                }

                long x = dq1.pollFirst();
                dq2.addLast(x);

                sum1 -= x;
                sum2 += x;

            } else {
                if (dq2.isEmpty()) {
                    return -1;
                }

                long x = dq2.pollFirst();
                dq1.addLast(x);

                sum1 += x;
                sum2 -= x;
            }

            turn++;
        }

        return -1;
    }
}