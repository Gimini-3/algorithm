class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s= s.toLowerCase();
        int numP=0;
        int numY=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'){
                numP++;
            }else if(s.charAt(i)=='y'){
                numY++;
            }
        }
        if(numP==numY){
            return true;
        }else{
            return false;
        }
    }
}