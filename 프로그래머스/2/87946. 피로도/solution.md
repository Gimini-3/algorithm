# 피로도

## 1. 생각 방식

던전을 도는 **순서에 따라 최대 탐험 개수가 달라지기 때문에 백트래킹**으로 모든 순서를 확인했다.

`visited`로 이미 선택한 던전을 체크하고, 현재 피로도가 최소 필요 피로도 이상이면 해당 던전을 탐험한다.

```java
if(k >= dun[i][0]){
    backTracking(idx + 1, k - dun[i][1], cnt + 1);
}
```

탐험이 끝나면 `visited[i]`를 다시 0으로 돌려서 다른 순서에서도 해당 던전을 사용할 수 있도록 했다.

```java
visited[i] = 0;
```

모든 경우를 확인하면서 탐험한 던전 수 `cnt`의 최댓값을 `result`에 저장했다.

---

## 2. 자료구조 선택 이유

어떤 던전을 이미 탐험했는지 확인해야 해서 `visited` 배열을 사용했다.

```java
int[] visited
```

`visited[i] == 1`이면 현재 탐색 순서에서 이미 사용한 던전이므로 넘어간다.

---

## 4. 시간복잡도

던전의 순서를 바꿔가며 모든 경우를 확인하므로 순열 탐색이 된다.

던전 개수를 `N`이라고 하면 대략

```text
O(N!)
```

형태이고, 각 재귀에서 전체 던전을 확인하는 것까지 포함하면 상한은 `O(N × N!)` 정도이다.

---

## 5. 코드 피드백

현재 코드는 피로도가 부족한 던전도

```java
visited[i] = 1;

if(k < dun[i][0]){
    backTracking(idx + 1, k, cnt);
}
```

처럼 방문 처리한 뒤 다음 단계로 넘기고 있다.

피로도는 탐험할수록 줄어들기만 하므로 **지금 못 가는 던전은 나중에도 갈 수 없다.**

따라서 못 가는 던전은 그냥

```java
if(k < dun[i][0]) continue;
```

로 넘기면 된다.

그리고 이렇게 바꾸면 모든 던전을 억지로 `idx == dun.length`까지 확인할 필요가 없다.

재귀에 들어올 때마다

```java
result = Math.max(result, cnt);
```

로 현재 탐험 개수를 저장하면 된다.

그래서 `idx`도 필요 없어진다.

`answer`도 실제로 사용하지 않으므로 제거할 수 있다.

### 수정한 전체 코드

```java
import java.util.*;

class Solution {

    static int[][] dun;
    static int result;
    static int[] visited;

    public int solution(int k, int[][] dungeons) {

        dun = dungeons;
        visited = new int[dun.length];
        result = 0;

        backTracking(k, 0);

        return result;
    }

    public void backTracking(int k, int cnt) {

        result = Math.max(result, cnt);

        for (int i = 0; i < dun.length; i++) {

            if (visited[i] == 1) continue;

            // 현재 피로도로 못 가면 넘어감
            if (k < dun[i][0]) continue;

            visited[i] = 1;

            backTracking(
                k - dun[i][1],
                cnt + 1
            );

            visited[i] = 0;
        }
    }
}
```

핵심은 기존 코드의 **던전 선택 → 방문 처리 → 재귀 → 방문 해제** 구조는 그대로 두고, **갈 수 없는 던전은 재귀를 돌지 않는 것**이다.
