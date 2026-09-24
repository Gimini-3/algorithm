class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        long sum = sequence[0];

        while (start <= end) {

            if (sum == k) {
                int currentLength = end - start + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = start;
                    answer[1] = end;
                }
            }

            if (sum >= k) {
                sum -= sequence[start];
                start++;
            } else {
                if (end == sequence.length - 1) {
                    break;
                }

                end++;
                sum += sequence[end];
            }
        }

        return answer;
    }
}