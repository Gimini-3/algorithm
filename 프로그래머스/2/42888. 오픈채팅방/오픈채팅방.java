import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        StringTokenizer st;
        List<Node> li = new ArrayList<>();
        for(int i=0;i<record.length;i++){
            st= new StringTokenizer(record[i]);
            String con= st.nextToken();
            String id = st.nextToken();
            String name="";
            if(!con.equals("Leave")) name = st.nextToken();
            switch(con){
                case "Enter":
                    li.add(new Node(con,id));
                    if(!map.containsKey(id)){
                        map.put(id,name);
                    }else{
                        String now= map.get(id);
                        if(!now.equals(name)){
                            map.put(id,name);
                        }
                    }
                    break;
                case "Leave":
                    li.add(new Node(con,id));
                    break;
                case "Change":
                    String now= map.get(id);
                    if(!now.equals(name)){
                        map.put(id,name);
                    }
            }
            
            
        }
        answer= new String[li.size()];
        StringBuilder sb;
        for(int j=0;j<li.size();j++){
            sb=new StringBuilder();
            String now_type = li.get(j).x;
            String now_id = li.get(j).id;
            String now_name = map.get(now_id);
            sb.append(now_name).append("님이");
            switch(now_type){
                case "Enter":
                    sb.append(" 들어왔습니다.");
                    break;
                case "Leave":
                    sb.append(" 나갔습니다.");
                    break;
            }
           // System.out.println(sb);
            answer[j]=sb.toString();
        }
        return answer;
    }
    public class Node{
        // 0: Enter 1: Leave
        String x;
        String id;
        
        public Node(String x,String id){
            this.x=x;
            this.id= id;
        }
    }
}