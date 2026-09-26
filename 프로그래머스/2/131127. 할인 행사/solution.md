# 할인 행사

## 1. 생각 방식

`HashMap`에 원하는 상품과 필요한 개수를 저장했다.

```java
map.put(want[i], number[i]);
```

먼저 첫 10일 동안 할인하는 상품을 확인하면서 원하는 상품이 나오면 필요한 개수를 하나씩 줄였다.

```java
map.put(discount[i], map.get(discount[i]) - 1);
```

그다음 길이가 10인 구간을 한 칸씩 옮기면서 확인했다.

현재 구간에서 모든 상품의 필요한 개수가 `0 이하`라면 원하는 상품을 전부 살 수 있으므로 `answer++` 했다.

구간을 옮길 때는

- 빠지는 상품 → 필요한 개수 `+1`
- 새로 들어오는 상품 → 필요한 개수 `-1`

로 처리했다.

```java
map.put(discount[left], map.get(discount[left]) + 1);
map.put(discount[right], map.get(discount[right]) - 1);
```

즉 **크기 10짜리 슬라이딩 윈도우**를 움직이면서 조건을 확인한 방식이다.

## 2. 자료구조 선택 이유

상품 이름마다 필요한 개수를 저장하고 계속 수정해야 해서 `HashMap<String, Integer>`를 사용했다.

```java
상품 이름 → 남은 필요 개수
```

상품이 현재 원하는 상품인지 `containsKey()`로 바로 확인할 수 있고, 개수도 `get()`, `put()`으로 바로 수정할 수 있다.

## 3. 기억할 문법

### `Map.Entry`

`HashMap`의 key와 value를 같이 순회할 때 사용한다.

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    int value = entry.getValue();
}
```

- `map.entrySet()` : `key-value` 쌍들을 가져옴
- `entry.getKey()` : key
- `entry.getValue()` : value

현재 코드에서는 key를 사용하지 않고 value만 필요하니까 사실 이렇게 해도 된다.

```java
for (int value : map.values()) {
    if (value <= 0) {
        cnt++;
    }
}
```

## 4. 시간복잡도

할인 배열을 한 칸씩 이동하면서 매번 `map`을 순회한다.

`D = discount.length`, `W = want.length`라고 하면

```text
O(D × W)
```

이다.

이 문제에서는 `want`의 크기가 작기 때문에 충분히 빠르다.

## 5. 코드 피드백

전체적인 접근은 잘 잡았다. **HashMap + 슬라이딩 윈도우**로 푼 게 핵심이다.

다만 이 부분은

```java
for(Map.Entry<String,Integer> entry: map.entrySet()){
    int value = entry.getValue();
    if(value<=0)cnt++;
}
```

key를 사용하지 않으니까 더 간단하게

```java
for (int value : map.values()) {
    if (value <= 0) cnt++;
}
```

로 쓰는 게 낫다.

그리고

```java
if(cnt == want.length)
```

보다는 현재 확인하고 있는 Map 자체를 기준으로

```java
if(cnt == map.size())
```

라고 하는 편이 코드 의미가 더 자연스럽다.

같은 풀이를 조금 정리하면:

```java
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // 첫 10일
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

            // 기존 구간에서 빠지는 상품
            if (map.containsKey(discount[left])) {
                map.put(discount[left], map.get(discount[left]) + 1);
            }

            left++;
            right++;

            // 새로운 구간에 들어오는 상품
            if (map.containsKey(discount[right])) {
                map.put(discount[right], map.get(discount[right]) - 1);
            }
        }

        return answer;
    }
}
```

네 원래 코드를 크게 바꾸기보다는 **`entrySet()` → `values()`**, `want.length → map.size()` 정도만 다듬는 게 제일 좋아.
