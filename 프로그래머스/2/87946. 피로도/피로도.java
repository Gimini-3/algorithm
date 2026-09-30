import java.util.*;
class Solution {
    public static int[][] dun;
    public static int result=Integer.MIN_VALUE;
    public static int[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dun=dungeons;
        visited=new int[dun.length];
        backTracking(0,k,0);
       
        
        
        return result;
    }
    
    public void backTracking(int idx,int k,int cnt){
        if(idx==dun.length){
           
            result=Math.max(result,cnt);
            return;
        }
        
        for(int i=0;i<dun.length;i++){
            if(visited[i]==1)continue;
            visited[i]=1;
            if(k<dun[i][0]){
                backTracking(idx+1,k,cnt);
            }else{
                backTracking(idx+1,k-dun[i][1],cnt+1);
            }
            visited[i]=0;
        }
    }
}