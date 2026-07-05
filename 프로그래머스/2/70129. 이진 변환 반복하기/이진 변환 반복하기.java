class Solution {
    public int[] solution(String s) {
        
        int num=0;
        int count =0;
        String str=s;
        int x=1;
        int y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
               count++;
            }
            else{
                y++;
            }
        }
        
        
        System.out.println(count+" "+y);
        while(true){
            if(count==1)break;
            int a,b;
            a=count;
            count=0;
            while(true){
                if(a==1){
                    count+=1;
                    break;
                }
                b=a%2;
                a=a/2;
                System.out.println(a+" "+b);
                if(b==0){
                    y++;
                }
                else{
                   count++; 
                }
                
            }
            x++;
            
        }
        
            
        int[] answer = new int[]{x,y};
        return answer;
    }
}

