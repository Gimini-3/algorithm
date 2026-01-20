import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] result;
    public static int[] parent;
    public static List<Integer>[] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st =new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        parent = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i=0;i<=n;i++)adj[i]=new ArrayList<>();
        
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        parent[r]=-1;
        buildTreeDfs(r);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            int x = Integer.parseInt(br.readLine());
            sb.append(result[x]).append('\n');
        }System.out.println(sb);
    }

    public static void buildTreeDfs(int node){
    //    System.out.println(node);
        int sum=1;
        for(int i=0;i<adj[node].size();i++){
            int nextNode = adj[node].get(i);
            if(parent[node]==nextNode)continue;
            parent[nextNode]=node;
            buildTreeDfs(nextNode);
            sum+=result[nextNode];
        }
        result[node]=sum;
        return;
    }
}