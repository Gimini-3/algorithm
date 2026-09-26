# 할인 행사

## 1. 생각 방식

원하는 상품과 필요한 개수를 `HashMap`에 저장한다.

처음 10일 동안 할인하는 상품을 확인하면서 원하는 상품이면 필요한 개수를 하나씩 줄인다.

이후 길이가 10인 구간을 한 칸씩 이동한다.

구간이 이동할 때

```java
빠지는 상품 → +1
들어오는 상품 → -1
```

로 처리한다.

현재 모든 상품의 값이 `0 이하`이면 원하는 상품을 전부 살 수 있으므로 `answer++` 한다.

## 2. 자료구조 선택 이유

상품 이름별로 필요한 개수를 관리해야 해서 `HashMap<String, Integer>`를 사용했다.

슬라이딩 윈도우가 이동할 때 상품 개수를 바로 수정할 수 있다.

## 3. 기억할 문법

### `Map.Entry`

Map의 key와 value를 같이 순회할 때 사용한다.

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    int value = entry.getValue();
}
```

value만 필요하면

```java
for (int value : map.values()) {
}
```

로 돌 수 있다.

## 4. 시간복잡도

각 구간마다 `map`을 한 번씩 확인한다.

`discount.length = N`, `want.length = M`이라 하면

```text
O(N × M)
```

## 5. 코드 피드백

`Map.Entry`로 돌았는데 key는 사용하지 않아서 `map.values()`로 바꿀 수 있다.

```java
for (int value : map.values()) {
    if (value <= 0) cnt++;
}
```

그리고

```java
if (cnt == want.length)
```

보다는 현재 `map`에 있는 모든 상품을 확인한다는 의미로

```java
if (cnt == map.size())
```

로 쓰는 게 더 자연스럽다.

### 수정한 전체 코드

```java
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }

        int left = 0;
        int right = 9;

        while (true) {
            int cnt = 0;

            for (int value : map.values()) {
                if (value <= 0) {
                    cnt++;
                }
            }

            if (cnt == map.size()) {
                answer++;
            }

            if (right == discount.length - 1) {
                break;
            }

            if (map.containsKey(discount[left])) {
                map.put(discount[left], map.get(discount[left]) + 1);
            }

            left++;
            right++;

            if (map.containsKey(discount[right])) {
                map.put(discount[right], map.get(discount[right]) - 1);
            }
        }

        return answer;
    }
}
```
