import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            String w =br.readLine();
            int k= Integer.parseInt(br.readLine());

            List<List<Integer>> list =new ArrayList<>(30);
            for(int i=0;i<30;i++){
                list.add(new ArrayList<>());
                
            }

            for(int i=0;i<w.length();i++){
                char a= w.charAt(i);
             //   System.out.println((int)a-'a');
                list.get((int)a-'a').add(i);
               
            }
            int min=Integer.MAX_VALUE;
            int max= 0;
            int count=0;
            for(int i=0;i<30;i++){
                int size= list.get(i).size();
                if(size<k)continue;
                count++;
           //     System.out.println((char)(i+'a'));
                for(int j=0;j<size-k+1;j++){
                    int left= list.get(i).get(j);
                    int right = list.get(i).get(j+k-1);
                    int gap= right-left+1;
                    min= Math.min(gap,min);
                    max=Math.max(gap,max);
                }
            }

            if(count==0)System.out.println("-1");
            else System.out.println(min+" "+max);
            
        }

    }

    public static class node{
        int x;
        int step;
        public node(int x,int step){
            this.x = x;
            this.step = step;
        }
    }
}