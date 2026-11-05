class Solution {
    public static int sum=0;
    public static int[] numbers2;
    public static int len;
    public static int target2;
    public static int answer=0;
    public int solution(int[] numbers, int target) {
       
        numbers2= numbers;
        len= numbers2.length;
        target2=target;
        dfs(0);
        return answer;
    }
    
    public void dfs(int idx){
        if(idx==len){
            if(sum==target2)answer++;
            return;
        }
        int val = numbers2[idx];
        sum+= val;
        dfs(idx+1);
        sum-=val;
        sum-=val;
        dfs(idx+1);
        sum+=val;
    }
}
