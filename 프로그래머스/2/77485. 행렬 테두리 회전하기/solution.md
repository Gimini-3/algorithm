# 행렬 테두리 회전하기

## 1. 생각 방식

먼저 문제에서 좌표가 `1행 1열`부터 시작하니까 배열도

```java
int[][] arr = new int[rows + 1][columns + 1];
```

로 만들어서 1부터 사용했다.

행렬의 초기값은 문제 조건대로

```java
arr[i][j] = (i - 1) * columns + j;
```

로 채웠다.

각 `query`마다

```java
(x1, y1) → (x1, y2) → (x2, y2) → (x2, y1) → (x1, y1)
```

순서로 테두리를 시계방향으로 돌았다.

방향은

```java
static int[] dx = {0, 1, 0, -1};
static int[] dy = {1, 0, -1, 0};
```

으로

```text
오른쪽 → 아래 → 왼쪽 → 위
```

순서로 만들었다.

현재 값을 바로 덮어쓰면 기존 값이 사라지기 때문에 `tmp`에 이전 값을 저장하면서 한 칸씩 밀었다.

```java
int tmp = arr[now_x][now_y];

int next_value = arr[next_x][next_y];
arr[next_x][next_y] = tmp;
tmp = next_value;
```

즉,

```text
현재 들고 있는 값(tmp)
        ↓
다음 칸에 저장
        ↓
다음 칸의 기존 값은 다시 tmp에 보관
```

하는 식으로 한 바퀴 돌렸다.

회전하면서 `tmp`에 들어오는 값 중 최솟값을 계속 구해서 `answer[i]`에 저장했다.

---

## 2. 자료구조 선택 이유

행렬의 특정 좌표를 계속 조회하고 값을 직접 변경해야 해서 `int[][]` 2차원 배열을 사용했다.

```java
int[][] arr = new int[rows + 1][columns + 1];
```

별도의 Queue 같은 자료구조에 테두리 값을 전부 저장하지 않고, `tmp` 하나만 이용해서 바로 회전시켰다.

---

## 4. 시간복잡도

한 번의 회전에서 확인하는 칸의 개수는 직사각형의 테두리 길이만큼이다.

```text
2 × (x2 - x1) + 2 × (y2 - y1)
```

따라서 한 query는 대략

```text
O(rows + columns)
```

이고, query 개수를 `Q`라고 하면 전체 시간복잡도는

```text
O(Q × (rows + columns))
```

이다.

---

## 5. 코드 피드백

현재 방식은 **테두리를 직접 따라가면서 `tmp`로 값을 밀어내는 방식**이라 그대로 사용해도 된다.

특히

```java
int next_value = arr[next_x][next_y];
arr[next_x][next_y] = tmp;
tmp = next_value;
```

이 부분이 이 풀이의 핵심이다.

`j == 0 || j == 2`로 가로 길이와 세로 길이를 구분한 부분은 맞지만,

```java
if(j == 0 || j == 2){
    turn = dist_y;
}else{
    turn = dist_x;
}
```

배열로 만들어두면 조금 더 간단하게 쓸 수 있다.

```java
int[] move = {dist_y, dist_x, dist_y, dist_x};
```

그리고 디버깅용 주석은 최종 코드에서는 빼면 된다.

### 정리한 전체 코드

```java
class Solution {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];
        int[][] arr = new int[rows + 1][columns + 1];

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                arr[i][j] = (i - 1) * columns + j;
            }
        }

        for(int i = 0; i < queries.length; i++){

            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int distX = x2 - x1;
            int distY = y2 - y1;

            int[] move = {distY, distX, distY, distX};

            int nowX = x1;
            int nowY = y1;

            int tmp = arr[nowX][nowY];
            int minValue = tmp;

            for(int j = 0; j < 4; j++){

                for(int t = 0; t < move[j]; t++){

                    int nextX = nowX + dx[j];
                    int nextY = nowY + dy[j];

                    int nextValue = arr[nextX][nextY];

                    arr[nextX][nextY] = tmp;
                    tmp = nextValue;

                    minValue = Math.min(minValue, tmp);

                    nowX = nextX;
                    nowY = nextY;
                }
            }

            answer[i] = minValue;
        }

        return answer;
    }
}
```

이 문제에서 기억할 핵심은 **값을 직접 옮길 때 덮어쓰기 전에 기존 값을 `tmp`에 보관하면서 이동시키는 것**이야.
