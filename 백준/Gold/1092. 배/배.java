import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        Integer [] arr= new Integer[n];
        for(int i=0;i<n;i++){
            int x= Integer.parseInt(st.nextToken());
            arr[i]=x;
        }    
        Arrays.sort(arr,(x,y)->{
           return Integer.compare(y,x); 
        });

    //    for(int a:arr){
    //        System.out.print(a+" ");
      //  }System.out.println();
        int m= Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        TreeMap<Integer,Integer> map = new TreeMap<>((x,y)->{
            return Integer.compare(y,x);
        });
        for(int i=0;i<m;i++){
            int x= Integer.parseInt(st.nextToken());
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int time=0;
        while(!map.isEmpty()){
            int count=0;
            for(int i=0;i<n;i++){
                int x= arr[i];
              //  System.out.println(x);
                Integer key= map.higherKey(x+1);
                if(key!=null){
              //      System.out.println("x:"+x+"key:"+key);
                    count++;
                    int v= map.get(key)-1;
                    if(v==0)map.remove(key);
                    else map.put(key,v);
                }

            }
            if(count==0){
                System.out.println("-1");
                return;
            }
            time++;
        }
        System.out.println(time);

        
    }
}