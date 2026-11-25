class Solution {
    public int solution(int[][] signals) {

        int maxTime = 1;

        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            maxTime = lcm(maxTime, cycle);
        }

        for (int time = 1; time <= maxTime; time++) {

            boolean allYellow = true;

            for (int[] signal : signals) {
                int G = signal[0];
                int Y = signal[1];
                int R = signal[2];

                int cycle = G + Y + R;
                int position = (time - 1) % cycle;

                if (position < G || position >= G + Y) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }

        return -1;
    }

    // 최대공약수
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    // 최소공배수
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}