# 배달

## 1. 생각 방식

1번 마을에서 시작해서 **K 시간 이하로 도달할 수 있는 마을의 개수**를 구해야 한다.

도로마다 걸리는 시간이 다르기 때문에 BFS가 아니라 **다익스트라 방식**으로 풀었다.

우선순위 큐에

```java
new Node(마을번호, 현재까지 걸린 시간)
```

을 넣고, 걸린 시간이 가장 작은 노드부터 꺼낸다.

```java
Node nod = pq.poll();
```

이미 방문한 마을이면 넘어가고, 처음 꺼낸 경우에는 그 경로가 해당 마을까지의 최소 시간이므로 방문 처리하고 `answer`를 증가시켰다.

```java
if(visited[nod.num] == 1) continue;

visited[nod.num] = 1;
answer++;
```

다음 마을로 이동했을 때 K를 넘어가면 어차피 배달할 수 없으므로 우선순위 큐에 넣지 않았다.

```java
if(nod.dist + nod2.dist > K) continue;
```

K 이하라면 지금까지 걸린 시간에 다음 도로의 시간을 더해서 다시 우선순위 큐에 넣었다.

```java
pq.add(new Node(nod2.num, nod.dist + nod2.dist));
```

---

## 2. 자료구조 선택 이유

각 마을에서 연결된 마을과 도로의 시간을 같이 저장해야 해서

```java
ArrayList<Node>[] list
```

형태의 인접 리스트를 사용했다.

가장 짧은 시간이 걸리는 경로부터 확인해야 해서 `PriorityQueue`를 사용했다.

```java
PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
    return a.dist - b.dist;
});
```

`dist`가 작은 `Node`부터 나오도록 해서 다익스트라 방식으로 탐색했다.

`visited`는 이미 최소 거리가 확정된 마을을 다시 처리하지 않기 위해 사용했다.

---

## 3. 시간복잡도

다익스트라에서 간선을 확인하면서 우선순위 큐에 삽입하고 삭제하므로

```text
O(E log E)
```

정도로 볼 수 있다.

일반적으로는 다익스트라의 시간복잡도를 **O(E log V)**로 표현한다.

---
일반적인 다익스트라 풀이


```Java
import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        dist[1] = 0;
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            // 이미 더 짧은 경로를 발견한 적이 있으면 무시
            if (now.dist > dist[now.num]) {
                continue;
            }
            for (Node next : graph[now.num]) {
                int nextDist = now.dist + next.dist;
                // 기존 거리보다 더 짧은 경로를 찾았을 때만 갱신
                if (nextDist < dist[next.num]) {
                    dist[next.num] = nextDist;
                    pq.add(new Node(next.num, nextDist));
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    static class Node {
        int num;
        int dist;
        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}
```

내 풀이와 차이점

| 내 풀이 | 일반적인 다익스트라 |
|---|---|
| `visited[]` 사용 | `dist[]` 사용 |
| 처음 PQ에서 꺼내면 최단거리 확정 | 더 짧은 경로를 발견할 때마다 `dist[]` 갱신 |
| 가능한 경로를 일단 PQ에 넣음 | 더 짧은 경로일 때만 PQ에 넣음 |
| `K`를 넘는 경로는 탐색 중 제거 | 전체 최단거리 계산 후 `K` 이하인지 확인 |
| 구현이 단순함 | 정석적인 다익스트라 구현 |

핵심 차이

```Java
// 내 풀이
pq.add(new Node(next.num, now.dist + next.dist));
```

난 일단 넣고 나중에 visited로 거르는 방식이고

```Java
// 일반 다익스트라
if (nextDist < dist[next.num]) {
    dist[next.num] = nextDist;
    pq.add(new Node(next.num, nextDist));
}
```

정석 다익스트라는 더 좋은 경로일 때만 PQ에 넣는 방식이다.
앞으로는 정석으로 풀기
