class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int limit = toMinutes(schedules[i]) + 10;
            boolean success = true;

            for (int j = 0; j < 7; j++) {
                int day = (startday - 1 + j) % 7 + 1;

                // 주말 제외
                if (day == 6 || day == 7) {
                    continue;
                }

                // 지각 여부 확인
                if (toMinutes(timelogs[i][j]) > limit) {
                    success = false;
                    break;
                }
            }

            if (success) {
                answer++;
            }
        }

        return answer;
    }

    private int toMinutes(int time) {
        return (time / 100) * 60 + time % 100;
    }
}