class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start_idx= 0;
        int end_idx=0;
        int length=Integer.MAX_VALUE;
        long sum= sequence[0];
        
        while(true){
           // System.out.println(start_idx+" "+end_idx+" "+sum);
            
            if(start_idx>=sequence.length)break;
            if(end_idx>=sequence.length)break;
            if(start_idx>end_idx)break;
            if(sum>k){
                sum-=sequence[start_idx];
                start_idx++;
            }else if(sum<k){
                if(end_idx<sequence.length-1){
                    end_idx++;
                    sum+=sequence[end_idx];
                }else if(end_idx==sequence.length-1){
                    break;
                }
            }else{
                if(end_idx-start_idx<length){
                    System.out.println("check"+start_idx+" "+end_idx+" "+sum);
                    length=end_idx-start_idx;
                
                    answer[0]=start_idx;
                    answer[1]=end_idx;
                }
                if(end_idx<sequence.length-1){
                    end_idx++;
                    sum+=sequence[end_idx];
                }else if(end_idx==sequence.length-1){
                    break;
                }
                
            }
        }
        return answer;
    }
}