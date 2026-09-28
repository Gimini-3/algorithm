class Solution {
    static int min_value=Integer.MAX_VALUE;
    static int[] pick;
    static String[] mineral;
    static int sum=0;
    static int[][] arr= {{1,1,1},{5,1,1},{25,5,1}};
    public int solution(int[] picks, String[] minerals) {
        
        int answer = 0;
        pick=picks;
        mineral=minerals;
        for(int i=0;i<3;i++){
            if(pick[i]==0)continue;
            backTracking(i,0);
            sum=0;
        }
        return min_value;
    }
    
    public void backTracking(int num, int idx){
        int turn =0;
        pick[num]-=1;
        for(int i=0;i<5;i++){
            if(idx+i==mineral.length){
                min_value=Math.min(min_value,sum+turn);
                 pick[num]+=1;
                return;
            }
            switch(mineral[idx+i]){
                case "diamond":
                    turn+=arr[num][0];
                    break;
                case "iron":
                    turn += arr[num][1];
                    break;
                case "stone":
                    turn += arr[num][2];
                    break;
            }
        }
       int che=0;
        for(int i=0;i<3;i++){
            if(pick[i]==0)che++;
        }
        if(che==3){
            min_value=Math.min(min_value,sum+turn);
            pick[num]+=1;
            return;
        }
        sum+=turn;
        for(int i=0;i<3;i++){
            if(pick[i]==0){
                continue;
            }
            backTracking(i,idx+5);
        }
        sum-= turn;
        pick[num]+=1;
    }
    
}