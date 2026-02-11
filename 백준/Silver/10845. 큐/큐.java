import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String str =br.readLine();
            String[] s = str.split(" ");
            switch(s[0]){
                case "push":
                    queue.addLast(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.pop()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    int exist = (queue.isEmpty()==true)?1:0;
                    sb.append(exist).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.getFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.getLast()).append("\n");
                    }
            }
            
        }
        System.out.println(sb);
    }
}