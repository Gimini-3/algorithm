import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        int[] answer = new int[sources.length];

        List<Integer>[] list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];

            list[a].add(b);
            list[b].add(a);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> que = new ArrayDeque<>();

        que.add(destination);
        dist[destination] = 0;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int j = 0; j < list[now].size(); j++) {
                int next = list[now].get(j);

                if (dist[next] != -1) continue;

                dist[next] = dist[now] + 1;
                que.add(next);
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}