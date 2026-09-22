import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(book_time,  (a,b)->{
            return a[0].compareTo(b[0]);
        });
        for(int i=0;i<book_time.length;i++){
            System.out.println(book_time[i][0]);
        }
        int[] rooms= new int[1001];
        for(int i=0;i<book_time.length;i++){
            String[] str1 = book_time[i][0].split(":");
            int total1 = Integer.parseInt(str1[0])*60+ Integer.parseInt(str1[1]);
            String[] str2 = book_time[i][1].split(":");
            int total2 = Integer.parseInt(str2[0])*60+ Integer.parseInt(str2[1]);
            if(!pq.isEmpty()){
                if(pq.peek()+10<=total1){
                    System.out.println("1 "+pq.peek()+" "+total2);
                    System.out.println("1 "+book_time[i][0]+" "+book_time[i][1]);
                    pq.poll();
                    
                }else {
                    System.out.println("2 "+book_time[i][0]+" "+book_time[i][1]);
                    answer++;
                }
            }else{
                System.out.println("3 "+book_time[i][0]+" "+book_time[i][1]);
                answer++;
            }
            pq.add(total2);
        }
     
        
        return answer;
    }
}