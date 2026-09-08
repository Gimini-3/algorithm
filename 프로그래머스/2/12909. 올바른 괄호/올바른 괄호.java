import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> deque = new ArrayDeque<>();
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                left++;
            }else{
                left--;
            }
            if(left<0){
                answer=false;
                return answer;
            }
        }
        if(left!=0)answer=false;

        return answer;
    }
}