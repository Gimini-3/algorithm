import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<node>> list = new ArrayList<>();
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int lev= Integer.parseInt(st.nextToken());
            String id= st.nextToken();
            if(list.size()==0){
                List<node> li = new ArrayList<>();
                li.add(new node(lev,id));
                list.add(li);
            }
            else{
                int che=0;
                for(int j=0;j<list.size();j++){
                    List<node> li = list.get(j);
                    if(li.size()==m)continue;
                    if(li.size()==0){
                     //   System.out.printf("Started! lev:%d id:%s\n",lev,id);
                        li.add(new node(lev,id));
                        che=1;
                        break;
                    }else{
                        int room_lev= li.get(0).lev;
                        if(lev<room_lev-10||lev>room_lev+10){
                            continue;
                        }
                        che=1;
                        li.add(new node(lev,id));
                       
                        break;
                    }
                }
                if(che==0){
               //     System.out.printf("Started! lev:%d id:%s\n",lev,id);
                    
                 //   sb.append("Started!").append('\n');
                    List<node> li = new ArrayList<>();
                    li.add(new node(lev,id));
                    list.add(li);
                }
            }
            
        }

        for(int i=0;i<list.size();i++){
            List<node> li = list.get(i);
            if(li.size()==m){
                sb.append("Started!").append('\n');
            }else{
                sb.append("Waiting!").append('\n');
            }
            li.sort((a,b)->{
                return (a.id).compareTo(b.id);
            });
            for(node no: li){
                sb.append(no.lev).append(" ").append(no.id).append('\n');
            }
        }
        
        System.out.println(sb);
    }

    public static class node{
        int lev;
        String id;
        public node(int lev, String id){
            this.lev = lev;
            this.id = id;
        }
    }
}