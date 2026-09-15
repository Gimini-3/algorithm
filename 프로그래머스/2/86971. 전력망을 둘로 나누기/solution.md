# 전력망을 둘로 나누기

## 1. 생각 방식

먼저 `wires`를 이용해서 양방향 그래프를 만들었다.

전선을 하나씩 끊어본다고 생각하고, 해당 전선의 한쪽 노드 `x`부터 BFS를 돌렸다.

탐색할 때 현재 끊은 전선 `x - y`는 지나가지 않도록 했다.

```java
if(now_node == x && next_node == y) continue;
if(now_node == y && next_node == x) continue;
```

BFS로 `x` 쪽 전력망에 몇 개의 송전탑이 있는지 `count`로 구했다.

그러면 반대쪽은 `n - count`개이므로 두 전력망의 차이는

```java
n - 2 * count
```

가 된다.

모든 전선을 하나씩 끊어보면서 차이의 최솟값을 구했다.

## 2. 자료구조 선택 이유

노드마다 연결된 노드가 여러 개 있을 수 있어서 인접 리스트로 그래프를 만들었다.

```java
ArrayList<Integer>[] graph
```

그래프 탐색은 `Deque`를 Queue처럼 사용해서 BFS로 했다.

## 3. 기억할 문법

### `ArrayList<Integer>[]`

```java
ArrayList<Integer>[] graph = new ArrayList[n + 1];

for(int i = 0; i < n + 1; i++){
    graph[i] = new ArrayList<>();
}
```

`ArrayList<Integer>`를 원소로 가지는 배열이다.

```java
graph[x].add(y);
graph[y].add(x);
```

양방향 연결이라 둘 다 추가한다.

### `Deque`로 Queue 사용

```java
Deque<Integer> deque = new ArrayDeque<>();

deque.addLast(x);
int now_node = deque.pollFirst();
```

* `addLast()` : 뒤에 추가
* `pollFirst()` : 앞에서 꺼냄

뒤에 넣고 앞에서 꺼내므로 **FIFO → BFS**가 된다.


전선은 총 `n - 1`개이고, 전선을 하나 끊어볼 때마다 그래프 전체를 탐색한다.

* 전선 하나 선택: `O(N)`
* 한 번 그래프 탐색: `O(N)`

따라서 전체 시간복잡도는 **O(N²)**이다.
