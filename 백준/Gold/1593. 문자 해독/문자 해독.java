import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String W = br.readLine();
        String S = br.readLine();
        Map<Character, Integer> want = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();
        for(int i=0;i<W.length();i++){
            char ch = W.charAt(i);
            want.put(ch,want.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch = S.charAt(i);
            cur.put(ch, cur.getOrDefault(ch,0)+1);
        }
        int che=0;
        for(Map.Entry<Character,Integer> e: want.entrySet()){
            char wantKey= e.getKey();
            int wantValue = e.getValue();
            Integer curValue = cur.get(wantKey);
           // System.out.printf("wantKey:%c wantValue:%d curValue:%d\n",wantKey,wantValue,curValue);
            if(curValue==null||curValue!=wantValue){
                che=1;
                break;
            }
        }
        int sum=0;
        if(che==0)sum++;
        che=0;
        
        for(int i=1;i<m-n+1;i++){
            char deleteChar = S.charAt(i-1);
            char addChar = S.charAt(i+n-1);
            cur.put(deleteChar,cur.get(deleteChar)-1);
            cur.put(addChar,cur.getOrDefault(addChar,0)+1);
            for(Map.Entry<Character,Integer> e: want.entrySet()){
                char wantKey= e.getKey();
                int wantValue = e.getValue();
                Integer curValue = cur.get(wantKey);
            //    System.out.printf("wantKey:%c wantValue:%d curValue:%d\n",wantKey,wantValue,curValue);
                
                if(curValue==null||curValue!=wantValue){
                    che=1;
                    break;
                }
            }
            if(che==0)sum++;
            che=0;
        }
        System.out.println(sum);
    }
    
}