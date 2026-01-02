import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            String str= br.readLine();
            int sum =0;
            for(int j=0;j<str.length();j++){
                char x= str.charAt(j);
                if(x>='1'&&x<='9'){
                    sum+= (int)(x-'0');
                }
            }
            list.add(new Pair(str, sum));
            
        }
        list.sort((x,y)->{
            if(x.str.length()!=y.str.length()){
                return x.str.length()<y.str.length()?-1:1;
            }else{
                if(x.sum!=y.sum){
                    return x.sum<y.sum?-1:1;
                }else{
                    return x.str.compareTo(y.str);
                }
            }
        });

        for(Pair p:list){
            System.out.println(p.str);
        }
    }

    public static class Pair{
        public String str;
        public int sum;
        public Pair(String str,int sum){
            this.str= str;
            this.sum = sum;
        }
    }
}