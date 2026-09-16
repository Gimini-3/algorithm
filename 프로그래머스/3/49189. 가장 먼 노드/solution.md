

Queue에 Node객체로 넣지 않고 dist[next] = dist[now] + 1;로 푸는 방법 
```JAVA
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            graph[x].add(y);
            graph[y].add(x);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(1);
        dist[1] = 0;

        int maxDist = 0;

        while (!deque.isEmpty()) {

            int now = deque.pollFirst();

            for (int next : graph[now]) {

                // 이미 방문한 노드
                if (dist[next] != -1) {
                    continue;
                }

                // 현재 노드 거리 + 1
                dist[next] = dist[now] + 1;

                maxDist = Math.max(maxDist, dist[next]);

                deque.addLast(next);
            }
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                cnt++;
            }
        }

        return cnt;
    }
}
```
