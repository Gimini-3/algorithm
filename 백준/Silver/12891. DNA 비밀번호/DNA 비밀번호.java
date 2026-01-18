import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int s= Integer.parseInt(st.nextToken());
        int p= Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',Integer.parseInt(st.nextToken()));
        map.put('C',Integer.parseInt(st.nextToken()));
        map.put('G',Integer.parseInt(st.nextToken()));
        map.put('T',Integer.parseInt(st.nextToken()));
        int result =0;
        for(int i=0;i<p;i++){
            char ch = str.charAt(i);
     //       System.out.print(ch);
            Integer x= map.get(ch);
            if(x!=null)map.put(ch,x-1);
        }
    //    System.out.println();
        
        int count = 0;
      //  for(Map.Entry<Character,Integer> e:map.entrySet()){
     //           System.out.print(e.getKey()+""+e.getValue()+" ");
     //       }System.out.println();
        for(Integer i:map.values()){
            if(i<=0)count++;
        }
        if(count==4)result++;
        for(int i=p;i<str.length();i++){
         //   System.out.println(str.charAt(i-p)+" "+str.charAt(i));
            Integer x= map.get(str.charAt(i-p));
            
            if(x!=null){
                map.put(str.charAt(i-p),x+1);
            }
            Integer y = map.get(str.charAt(i));
            if(y!=null)map.put(str.charAt(i),y-1);
            count=0;
           // for(Map.Entry<Character,Integer> e:map.entrySet()){
           //     System.out.print(e.getKey()+""+e.getValue()+" ");
          //  }System.out.println();
            for(Integer t:map.values()){
                if(t<=0)count++;
            }
            if(count==4) result++;
        }
        //a b c d e f
        //0 1 2 3 4 5 
        System.out.println(result);
    }
}