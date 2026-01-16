import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        int n= Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str = br.readLine();
            set.add(str);
        }
       List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        
      //  list.sort((x,y)->{
      //     return a.compareTo(b); 
      //  });
        int num=list.size();
        String str=list.get(0);
        int i=1;
        while(true){
            
            if(i==list.size())break;
            String str2= list.get(i);
            if(str2.startsWith(str)){
                str= str2;
                num--;
                i++;
            }else{
                str=str2;
                i++;
                
            }
            
        }
        System.out.println(num);
    }
}