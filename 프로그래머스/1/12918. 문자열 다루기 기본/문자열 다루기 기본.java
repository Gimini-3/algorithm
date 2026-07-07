class Solution {
    public boolean solution(String s) {
        if(s.length()!=4&&s.length()!=6){
            return false;
        }
        if(!s.matches("[0-9]+")){
            return false;
        }
         return true;
    }
}