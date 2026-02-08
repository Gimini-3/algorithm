import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            deque.addLast(i);
        }

        while(deque.size()>1){
            deque.removeFirst();
            if(deque.size()==1){
                break;
            }
            int x=deque.removeFirst();
            deque.addLast(x);
        }
        System.out.println(deque.removeFirst());
    }
}