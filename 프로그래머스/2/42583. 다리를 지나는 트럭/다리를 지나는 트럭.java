import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int now_weight = weight;
        
        Deque<Integer> que = new ArrayDeque<>();
        Deque<Node> que2 = new ArrayDeque<>();
        
        int time = 1;

        for (int truck : truck_weights) {
            que.addLast(truck);
        }

        while (!que.isEmpty()) {

            while (!que2.isEmpty() && que2.peekFirst().end_time < time) {
                Node nod = que2.pollFirst();
                now_weight += nod.wei;
            }

            int next = que.peekFirst();

            if (next <= now_weight && que2.size() < bridge_length) {
                que2.addLast(new Node(next, time + bridge_length - 1));
                que.pollFirst();
                now_weight -= next;
                time++;
            } else {
                Node nod = que2.peekFirst();
                time = nod.end_time + 1;
            }
        }

        return que2.peekLast().end_time + 1;
    }

    public class Node {
        public int wei;
        public int end_time;

        public Node(int wei, int end_time) {
            this.wei = wei;
            this.end_time = end_time;
        }
    }
}