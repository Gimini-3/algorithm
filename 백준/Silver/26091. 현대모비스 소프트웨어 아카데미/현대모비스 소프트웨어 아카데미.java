import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n==1){
            System.out.println("0");
            return;
        }
        List<Integer> list  = new ArrayList<>();
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }

        list.sort((x,y)->{
            return Integer.compare(y,x);
        });
     //   System.out.println(1);

        int left = 0;
        int right = list.size()-1;
        
        
        int cnt = 0;
        while(true){
            if(left>=right)break;
            int x=list.get(left);
            int y=list.get(right);
       //     System.out.println(left+" "+right);
            if(x+y>=m){
                cnt++;
                left++;
                right--;
            }else{
                right--;
            }
        }    
        System.out.println(cnt);
    }

    public static class node{
        int x;
        int lev;
         public node(int x,int lev){
            this.x=x;
            this.lev=lev;
        }
    }
}