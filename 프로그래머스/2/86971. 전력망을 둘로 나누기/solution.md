# 전력망을 둘로 나누기

## 1. 생각 방식

먼저 `wires`를 이용해서 양방향 그래프를 만들었다.

전선을 하나씩 끊어보면서, 끊은 전선의 한쪽 노드 `x`에서 탐색을 시작한다.

탐색할 때 현재 끊은 전선인 `x ↔ y`는 지나가지 않도록 제외했다.

```java
if(now_node==x && next_node==y) continue;
if(now_node==y && next_node==x) continue;
```

탐색하면서 연결된 노드 개수를 `count`로 센다.

그러면 두 전력망의 송전탑 개수는

```text
count
n - count
```

이므로 차이는

```java
Math.abs(count - (n - count))
```

이고, 코드에서는 같은 의미로

```java
Math.abs(n - 2 * count)
```

를 사용했다.

모든 전선을 한 번씩 끊어보고 가장 작은 차이를 `answer`에 저장했다.

---

## 2. 자료구조 선택 이유

그래프에서 한 노드와 연결된 노드들을 저장해야 해서 **인접 리스트**를 사용했다.

```java
ArrayList<Integer>[] graph
```

그래프를 탐색할 때는 `Deque`를 사용했다.

내 코드에서는

```java
deque.addLast()
deque.pollLast()
```

를 같이 사용해서 가장 마지막에 넣은 노드를 먼저 꺼내므로 **DFS 방식**으로 탐색한다.

---

## 3. 기억할 문법

### `ArrayList<Integer>[]`

```java
ArrayList<Integer>[] graph = new ArrayList[n + 1];

for (int i = 0; i < n + 1; i++) {
    graph[i] = new ArrayList<>();
}
```

각 인덱스마다 `ArrayList<Integer>`가 하나씩 있는 배열.

```java
graph[x].add(y);
graph[y].add(x);
```

이렇게 하면 `x`와 `y`가 서로 연결되어 있다는 것을 저장할 수 있다.

### `deque.addLast()`

```java
deque.addLast(x);
```

Deque의 **뒤쪽에 값을 추가**한다.

내 코드에서는

```java
deque.addLast(next_node);
int now_node = deque.pollLast();
```

뒤에 넣고 뒤에서 꺼내기 때문에 **Stack처럼 LIFO로 사용**한 것이다.

---

## 4. 시간복잡도

전선은 총 `n - 1`개이고, 전선을 하나 끊어볼 때마다 그래프 전체를 탐색한다.

* 전선 하나 선택: `O(N)`
* 한 번 그래프 탐색: `O(N)`

따라서 전체 시간복잡도는 **O(N²)**이다.
