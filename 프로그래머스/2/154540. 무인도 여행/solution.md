# 무인도 여행

## 1. 생각 방식

`maps`를 숫자 배열로 바꾼 뒤, 아직 방문하지 않은 땅을 발견하면 BFS를 시작했다.

BFS를 돌면서 상하좌우로 연결된 땅의 숫자를 `sum`에 더해서 하나의 무인도에서 머물 수 있는 날짜를 구했다.

```java
sum += map[now.x][now.y];
```

하나의 무인도 탐색이 끝나면 구한 `sum`을 `ans_queue`에 저장했다.

```java
ans_queue.addLast(sum);
```

모든 칸을 확인한 뒤 무인도가 하나도 없으면 `-1`을 반환하고, 무인도가 있으면 결과를 `int[]`로 바꾼 뒤 오름차순으로 정렬했다.

---

## 2. 자료구조 선택 이유

상하좌우로 연결된 땅을 탐색해야 해서 `Deque<Node>`를 Queue처럼 사용해 BFS로 풀었다.

```java
Deque<Node> que = new ArrayDeque<>();
```

방문한 칸을 다시 탐색하지 않도록 `visited` 배열을 사용했다.

각 무인도에서 구한 합을 저장하기 위해 `Deque<Integer>`를 사용했다.

---

## 3. 기억할 문법

### `Deque<Integer>` → `int[]`

```java
int[] arr = queue.stream()
                 .mapToInt(Integer::intValue)
                 .toArray();
```

각 부분은 이렇게 보면 된다.

```java
queue.stream()
```

`queue`의 원소들을 Stream으로 만든다.

현재 원소 타입은

```text
Integer
```

이다.

그다음

```java
.mapToInt(Integer::intValue)
```

`Integer`를 기본형 `int`로 변환한다.

```java
Integer::intValue
```

는 아래와 같은 의미다.

```java
x -> x.intValue()
```

즉

```java
.mapToInt(Integer::intValue)
```

와

```java
.mapToInt(x -> x.intValue())
```

는 같다.

마지막으로

```java
.toArray();
```

하면 `IntStream`을 `int[]`로 만든다.

전체 흐름은

```text
Deque<Integer>
    ↓ stream()
Stream<Integer>
    ↓ mapToInt()
IntStream
    ↓ toArray()
int[]
```

---

## 4. 시간복잡도

모든 칸은 BFS에서 한 번씩만 방문한다.

맵의 크기가 `N × M`이면 BFS는

```text
O(N × M)
```

이다.

마지막 결과 정렬은 무인도 개수를 `K`라고 하면

```text
O(K log K)
```

이므로 전체는

```text
O(N × M + K log K)
```

이다.

---

## 5. 코드 피드백

현재 풀이는 BFS 흐름 자체는 그대로 두면 된다.

다시 볼 때 수정할 부분은 두 가지 정도다.

디버깅할 때 사용한

```java
System.out.print(map[i][j] + " ");
```

부분은 제출 코드에서는 빼기.

그리고 경계 검사는

```java
if(nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1)
```

보다

```java
if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
```

으로 쓰는 게 보기 편하다.

또 결과만 모으는 용도라면 `Deque<Integer>`보다 `List<Integer>`를 사용하는 것도 더 자연스럽다.

### 수정한 전체 코드

```java
import java.util.*;

class Solution {

    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};

    public int[] solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char ch = maps[i].charAt(j);

                if (ch == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = ch - '0';
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (visited[i][j] != 0) continue;
                if (map[i][j] == 0) continue;

                Deque<Node> que = new ArrayDeque<>();

                que.addLast(new Node(i, j));
                visited[i][j] = 1;

                int sum = 0;

                while (!que.isEmpty()) {

                    Node now = que.pollFirst();

                    sum += map[now.x][now.y];

                    for (int t = 0; t < 4; t++) {

                        int nextX = now.x + dx[t];
                        int nextY = now.y + dy[t];

                        if (nextX < 0 || nextX >= n ||
                            nextY < 0 || nextY >= m) {
                            continue;
                        }

                        if (map[nextX][nextY] == 0) continue;
                        if (visited[nextX][nextY] != 0) continue;

                        visited[nextX][nextY] = 1;
                        que.addLast(new Node(nextX, nextY));
                    }
                }

                result.add(sum);
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        int[] answer = result.stream()
                             .mapToInt(Integer::intValue)
                             .toArray();

        Arrays.sort(answer);

        return answer;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
```

이 문제에서 따로 기억할 문법은 **`stream() → mapToInt() → toArray()`로 `Integer` 컬렉션을 `int[]`로 바꾸는 부분** 정도만 잡아두면 돼.
