import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            String str= phone_book[i];
            for(int j=1;j<str.length();j++){
                set.add(str.substring(0,j));
            }
        }
        for(int i=0;i<phone_book.length;i++){
            String str= phone_book[i];
            if(set.contains(str)){
                answer=false;
                break;
            }
        }
        return answer;
    }
}