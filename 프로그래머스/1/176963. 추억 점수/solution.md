# 추억 점수

## 1. 생각 방식

먼저 사람 이름과 그 사람의 그리움 점수를 `HashMap`에 저장했다.

```java
score.put(name[i], yearning[i]);
```

그다음 사진을 하나씩 돌면서, 사진에 있는 사람들의 점수를 전부 더했다.

```java
for (String person : photo[i]) {
    sum += score.getOrDefault(person, 0);
}
```

사진에 있는 사람이 `name`에 없는 경우도 있으므로 `getOrDefault()`로 없으면 0점을 더하게 했다.

각 사진의 합을 `answer[i]`에 저장했다.

## 2. 자료구조 선택 이유

이름으로 점수를 바로 찾아야 해서 `HashMap<String, Integer>`를 사용했다.

```java
이름 → 그리움 점수
```

사진을 볼 때마다 이름으로 점수를 바로 찾을 수 있다.

## 3. 기억할 문법

### `getOrDefault()`

```java
score.getOrDefault(person, 0)
```

`person`이 Map에 있으면 해당 점수를 가져오고, 없으면 `0`을 반환한다.

## 4. 시간복잡도

`name`을 한 번 돌면서 Map을 만들고, `photo` 안의 모든 사람을 한 번씩 확인한다.

사진 속 전체 사람 수를 `P`라고 하면 전체 시간복잡도는

```text
O(N + P)
```

이다.

## 5. 코드 피드백

지금 코드는 이 문제에서 거의 그대로 써도 된다.

불필요한 자료구조도 없고, `getOrDefault()`를 써서 사람 이름이 없는 경우까지 깔끔하게 처리했다.

굳이 바꿀 부분이 있다면 `score`라는 이름을 `map`이나 `scoreMap`으로 써도 되지만 지금도 충분히 의미가 잘 보인다.

### 정리한 전체 코드

```java
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> score = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {

            int sum = 0;

            for (String person : photo[i]) {
                sum += score.getOrDefault(person, 0);
            }

            answer[i] = sum;
        }

        return answer;
    }
}
```

핵심은 **이름 → 점수로 HashMap을 만들어두고 사진마다 점수를 바로 조회하는 것**이야.
