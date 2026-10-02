class Solution {
    public int[] solution(int[] answers) {

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int[] cnt = new int[3];

        for(int i=0;i<answers.length;i++){

            if(answers[i]==one[i%one.length]){
                cnt[0]++;
            }

            if(answers[i]==two[i%two.length]){
                cnt[1]++;
            }

            if(answers[i]==three[i%three.length]){
                cnt[2]++;
            }
        }

        int max = Math.max(cnt[0], Math.max(cnt[1],cnt[2]));

        int size=0;

        for(int i=0;i<3;i++){
            if(cnt[i]==max){
                size++;
            }
        }

        int[] answer = new int[size];
        int index=0;

        for(int i=0;i<3;i++){
            if(cnt[i]==max){
                answer[index]=i+1;
                index++;
            }
        }

        return answer;
    }
}