# 광물 캐기

## 1. 생각 방식

곡괭이 종류마다 광물을 캤을 때 드는 피로도가 다르기 때문에, **사용 가능한 곡괭이 순서를 전부 만들어보는 백트래킹**으로 풀었다.

곡괭이 하나를 선택하면 최대 5개의 광물을 캔다.

```java
pick[num] -= 1;
```

선택한 곡괭이로 현재 위치부터 최대 5개까지 캤을 때의 피로도를 `turn`에 저장했다.

```java
for (int i = 0; i < 5; i++) {
    ...
    turn += arr[num][광물종류];
}
```

현재까지의 피로도 `sum`에 `turn`을 더하고, 남아 있는 다른 곡괭이를 하나씩 선택하면서 다음 5개의 광물을 확인했다.

```java
sum += turn;

for (int i = 0; i < 3; i++) {
    if (pick[i] == 0) continue;

    backTracking(i, idx + 5);
}
```

탐색이 끝나면 사용했던 곡괭이와 `sum`을 원래 상태로 돌려놨다.

```java
sum -= turn;
pick[num] += 1;
```

광물을 전부 캤거나 곡괭이를 전부 사용하면 지금까지의 피로도와 `min_value`를 비교했다.

---

## 2. 자료구조 선택 이유

곡괭이 종류가 `다이아 / 철 / 돌` 3개로 고정되어 있어서 `int[]`로 남은 개수를 관리했다.

```java
pick[0] // 다이아 곡괭이
pick[1] // 철 곡괭이
pick[2] // 돌 곡괭이
```

곡괭이와 광물 조합에 따른 피로도도 경우의 수가 `3 × 3`으로 고정되어 있어서 2차원 배열로 저장했다.

```java
static int[][] arr = {
    {1, 1, 1},
    {5, 1, 1},
    {25, 5, 1}
};
```

행은 곡괭이 종류, 열은 광물 종류로 사용했다.

---

## 4. 시간복잡도

광물을 5개씩 하나의 구간으로 생각하면 구간 수를 `G`라고 할 수 있다.

각 구간마다 최대 3개의 곡괭이를 선택할 수 있으므로 최악의 경우 대략

```text
O(3^G)
```

형태의 백트래킹이 된다.

실제로는 곡괭이마다 사용할 수 있는 개수가 제한되어 있어서 모든 경우를 다 탐색하지는 않는다.

---

## 5. 코드 피드백

현재 코드에서는 `sum`을 전역으로 두고

```java
sum += turn;

// 재귀

sum -= turn;
```

형태로 직접 원상복구하고 있다.

이 방법도 되지만 `sum`을 재귀 함수의 인자로 넘기면 상태 복구를 신경 쓸 부분이 줄어든다.

또 현재는

```java
backTracking(i, 0);
```

을 바깥에서 곡괭이별로 한 번씩 호출하고 있는데, 곡괭이를 선택하는 부분까지 `backTracking()` 안에 넣으면 흐름이 단순해진다.

그리고 광물을 정확히 5개 단위로 다 캔 경우 현재 코드는 다음 곡괭이를 한 번 더 선택한 후

```java
if(idx + i == mineral.length)
```

에서 종료될 수 있다.

재귀 시작 부분에서

```java
if (idx >= mineral.length)
```

를 먼저 검사하면 필요 없는 재귀를 줄일 수 있다.

### 수정한 전체 코드

```java
class Solution {

    static int minValue;
    static int[] pick;
    static String[] mineral;

    static int[][] arr = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };

    public int solution(int[] picks, String[] minerals) {

        minValue = Integer.MAX_VALUE;
        pick = picks;
        mineral = minerals;

        backTracking(0, 0);

        return minValue;
    }

    public void backTracking(int idx, int sum) {

        // 광물을 전부 캔 경우
        if (idx >= mineral.length) {
            minValue = Math.min(minValue, sum);
            return;
        }

        // 이미 최소 피로도보다 커진 경우 더 볼 필요 없음
        if (sum >= minValue) {
            return;
        }

        boolean hasPick = false;

        for (int num = 0; num < 3; num++) {

            if (pick[num] == 0) {
                continue;
            }

            hasPick = true;
            pick[num]--;

            int turn = 0;

            for (int i = 0; i < 5 && idx + i < mineral.length; i++) {

                switch (mineral[idx + i]) {
                    case "diamond":
                        turn += arr[num][0];
                        break;

                    case "iron":
                        turn += arr[num][1];
                        break;

                    case "stone":
                        turn += arr[num][2];
                        break;
                }
            }

            backTracking(idx + 5, sum + turn);

            pick[num]++;
        }

        // 광물은 남아있는데 사용할 곡괭이가 없는 경우
        if (!hasPick) {
            minValue = Math.min(minValue, sum);
        }
    }
}
```

내 코드에서 핵심 아이디어인 **곡괭이를 하나 선택 → 5개 채굴 → 다음 곡괭이 선택 → 원상복구** 구조는 그대로 두고, `sum`만 재귀 인자로 넘기는 식으로 정리한 코드다.
