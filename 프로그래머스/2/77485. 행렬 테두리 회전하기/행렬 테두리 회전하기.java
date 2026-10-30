class Solution {
    
    public static int[] dx={0,1,0,-1};
    public static int[] dy={1,0,-1,0};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr= new int[rows+1][columns+1];
        
        for(int i=1;i<rows+1;i++){
            for(int j=1;j<columns+1;j++){
                arr[i][j]=(i-1)*columns + j;
                
            }
        }
       
        
        for(int i=0;i<queries.length;i++){
            int x1=queries[i][0];
            int y1=queries[i][1];
            int x2=queries[i][2];
            int y2=queries[i][3];
            int dist_x= x2-x1;
            int dist_y= y2-y1;
            int now_x= x1;
            int now_y= y1;
            int min_value = arr[x1][y1];
            int turn;
            int tmp=arr[now_x][now_y];
          //  System.out.println(tmp);
            for(int j=0;j<4;j++){
                if(j==0||j==2){
                    turn = dist_y;
                }else{
                    turn = dist_x;
                }
              //  System.out.println("turn:"+turn);
                
                for(int t=0;t<turn;t++){
                    int next_x= now_x+dx[j];
                    int next_y= now_y+dy[j];
                    int next_value= arr[next_x][next_y];
                    arr[next_x][next_y]= tmp;
                    tmp=next_value;
                    now_x= next_x;
                    now_y= next_y;
                    min_value= Math.min(min_value, tmp);
                }
                
            }
            answer[i]=min_value;
            
        }
        
        return answer;
    }
}