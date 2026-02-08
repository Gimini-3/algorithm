import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();

        // 인덱스 0 제거용
        list.add(new ArrayList<>());
        
        for(int i=1;i<=n;i++){
            List<Integer> list2 = new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            while(true){
                int x= Integer.parseInt(st.nextToken());
                if(x==0){
                    break;
                }
                list2.add(x);
            }
            list.add(list2);
        }
        for(int i=1;i<=n;i++){
         //   System.out.print(i+": ");
            List<Integer> list2= list.get(i);
         //   for(int j=0;j<list2.size();j++){
         //       System.out.print(list2.get(j)+" ");
        //    }System.out.println();
        }

        int m = Integer.parseInt(br.readLine());
        Deque<node> queue= new ArrayDeque<>();
        st= new StringTokenizer(br.readLine());
         int[] che = new int[n+1];
        for(int i=0;i<m;i++){
            int x = Integer.parseInt(st.nextToken());
            queue.addLast(new node(0,x));
            che[x]=1;
        }

        
        int[] arr = new int[n+1];
        int[] cnt = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=-1;
        }

        while(!queue.isEmpty()){
            node no = queue.removeFirst();
            int x= no.x;
            arr[x]=no.cnt;
          //  System.out.println(x+" "+no.cnt);
            List<Integer> li = list.get(x);
            for(int i=0;i<li.size();i++){
                int nextX= li.get(i);
                if(che[nextX]==1)continue;
                cnt[nextX]++;
              //  System.out.printf("nextX:%d li.size():%d (li.size()+1)/2:%d cnt[nextX]:%d\n",nextX,li.size(),(li.size()+1)/2,cnt[nextX]);
                if((list.get(nextX).size()+1)/2<=cnt[nextX]){
                    che[nextX]=1;
                    queue.addLast(new node(no.cnt+1,nextX));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(arr[i]).append(" ");
        }System.out.println(sb);
    }

    public static class node{
        int cnt;
        int x;
        public node(int cnt, int x){
            this.cnt = cnt;
            this.x= x;
        }
    }
 
}