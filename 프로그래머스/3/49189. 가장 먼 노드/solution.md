# 가장 먼 노드

## 1. 생각 방식

1번 노드에서 가장 멀리 떨어진 노드가 몇 개인지 구하는 문제라서 BFS로 탐색했다.

먼저 `edge`를 이용해서 양방향 그래프를 만든다.

내 풀이에서는 Queue에 `Node` 객체를 넣어서

```java
new Node(거리, 노드번호)
```

형태로 현재 노드와 1번 노드부터의 거리를 같이 저장했다.

BFS는 가까운 거리부터 탐색되기 때문에 거리가 바뀔 때마다 `cnt`를 다시 1로 초기화하고, 같은 거리의 노드가 나오면 `cnt`를 증가시켰다.

```java
if(now_dist != now_node.dist){
    cnt = 1;
    now_dist = now_node.dist;
}else{
    cnt++;
}
```

BFS가 끝났을 때 마지막으로 탐색한 거리가 가장 먼 거리이므로 `cnt`를 반환했다.

---

## 2. 자료구조 선택 이유

노드마다 연결된 노드들을 저장하기 위해 인접 리스트를 사용했다.

```java
List<Integer>[] graph
```

1번 노드부터 가까운 순서대로 탐색해야 해서 `Deque`를 Queue처럼 사용해 BFS를 구현했다.

```java
deque.addLast();
deque.pollFirst();
```

방문한 노드를 다시 탐색하지 않기 위해 `visited` 배열도 사용했다.

---

## 3. 다른 풀이 - `dist` 배열 사용

Queue에 `Node` 객체를 넣지 않고 **노드 번호만 저장하고 거리 정보를 배열로 따로 관리**할 수도 있다.

```java
int[] dist = new int[n + 1];
Arrays.fill(dist, -1);

deque.addLast(1);
dist[1] = 0;
```

새로운 노드를 처음 방문했을 때

```java
dist[next] = dist[now] + 1;
```

로 현재 노드에서 한 칸 더 떨어져 있다는 것을 저장한다.

이렇게 하면

```java
Node(dist, value)
```

객체를 따로 만들 필요가 없다.

전체 코드:

```java
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
                if (dist[next] != -1) {
                    continue;
                }

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

개인적으로 이 문제에서는 `Node` 객체를 만드는 방법보다 **`dist[]`로 거리와 방문 여부를 같이 관리하는 방법이 더 단순하다.**

## 4. 시간복잡도

그래프 생성에 `O(E)`, BFS에서 모든 노드와 간선을 한 번씩 확인하므로

```text
O(N + E)
```

이다.
