import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        System.out.println(people[0]);
        int left = 0;
        int right = people.length-1;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                answer++;
                left++;
                right--;
            }else{
                answer+=1;
                right--;
            }
        }
        return answer;
    }
}