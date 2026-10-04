class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        int move = len - 1;

        for(int i=0;i<len;i++){

            int val = name.charAt(i) - 'A';
            answer += Math.min(val, 26-val);

            int next = i + 1;

            while(next < len && name.charAt(next) == 'A'){
                next++;
            }

            // System.out.println("i "+i+" next "+next);
            // System.out.println(name.charAt(i)+" "+Math.min(val, 26-val)+" answer "+answer);

            int right = i * 2 + (len-next);
            int left = i + (len-next) * 2;

            // System.out.println("right "+right+" left "+left+" move "+move);

            move = Math.min(
                move,
                right
            );

            move = Math.min(
                move,
                left
            );

            // System.out.println("move "+move);
        }

        answer += move;

        // System.out.println("answer "+answer);

        return answer;
    }
}