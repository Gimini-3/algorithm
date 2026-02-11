import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sca =new Scanner(System.in);
        int n = sca.nextInt();
        int k = sca.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++)list.add(i);

        int idx=0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(list.size()>0){
            idx= (idx+k-1)%list.size();
            int x= list.get(idx);
            list.remove(idx);
            if(list.size()==0){
                sb.append(x).append(">");
                System.out.println(sb);
                return;
            }
            sb.append(x).append(", ");
            
        }
 
    }
}