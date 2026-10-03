import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer=0;
        while(true){
            if(storey==0)break;
            int x = storey %10;
            int y = storey / 10;
            if(x<5){
                answer+=x;
            }else if( x==5){
                answer+=5;
                if(y%10>=5){
                    storey+=10;
                }
            }else if(x>5){
                answer+=10-x;
                storey+=10;
            }
            storey=storey/10;
        }
        return answer;
    }
}