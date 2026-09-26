# 택배 배달과 수거하기

## 1. 생각 방식

가장 먼 집까지 한 번 갔다 오면 그보다 가까운 집들은 가는 길에 같이 처리할 수 있다.

그래서 매번 **아직 배달이나 수거가 남아 있는 가장 먼 집**을 기준으로 이동 거리를 계산했다.

```java
answer += Math.max(dist1, dist2) * 2L;
```

한 번 이동할 때 배달은 `cap`만큼, 수거도 `cap`만큼 가능하므로 각각 가장 먼 곳부터 `cap`만큼 처리했다.

내 코드에서는 가장 먼 위치를 바로 찾기 위해 `TreeMap`을 내림차순으로 만들었다.

---

## 2. 자료구조 선택 이유

배달과 수거에서 **현재 남아 있는 가장 먼 집을 계속 찾아야 해서 `TreeMap`**을 사용했다.

```java
TreeMap<Integer, Integer> map1 =
        new TreeMap<>(Comparator.reverseOrder());
```

`key`에는 집의 거리, `value`에는 남은 택배 개수를 저장했다.

내림차순으로 만들어서

```java
map1.firstKey();
```

만 사용하면 현재 가장 먼 집을 바로 찾을 수 있다.

---

## 3. 기억할 문법

### TreeMap

```java
TreeMap<Integer, Integer> map =
        new TreeMap<>(Comparator.reverseOrder());
```

key를 내림차순으로 정렬해서 저장한다.

```java
map.put(key, value);
```

값 저장

```java
map.get(key);
```

해당 key의 값 가져오기

```java
map.firstKey();
```

현재 가장 앞에 있는 key를 가져온다.

내림차순으로 만들었기 때문에 이 문제에서는 **가장 먼 거리**가 나온다.

```java
map.remove(key);
```

해당 key 삭제

```java
map.isEmpty();
```

Map이 비었는지 확인

---

## 4. 시간복잡도

`TreeMap`의 `put`, `get`, `remove`는 `O(log N)`이다.

현재 코드는 운행할 때마다 `TreeMap`을 수정하기 때문에 운행 횟수를 `T`라고 하면 대략

```text
O((N + T) log N)
```

정도로 볼 수 있다.

이 문제는 집이 이미 거리 순서대로 배열에 들어오기 때문에 `TreeMap`을 사용하지 않고 배열을 뒤에서부터 보면 더 단순하게 풀 수 있다.

---

## 5. 코드 피드백

`TreeMap`으로 가장 먼 집을 찾는 방식은 가능하지만, 이미

```java
deliveries[i]
pickups[i]
```

에서 `i`가 클수록 먼 집이기 때문에 정렬된 자료구조를 따로 만들 필요는 없다.

배열을 **뒤에서부터 앞으로** 확인하면 된다.

또 현재 코드는 배달과 수거를 각각 `while`로 처리하고 있는데, 이전에 멀리까지 갔던 운행에서 남은 용량을 음수로 저장하면 한 번의 역순 순회로 처리할 수 있다.

예를 들어

```java
delivery -= trips * cap;
```

했을 때 `delivery = -2`가 됐다면, 이미 계산한 운행에서 **배달 공간 2개가 남아 있다**는 뜻이다.

다음 집의 배달량을 더했을 때 그 남은 공간부터 사용하면 된다.

### 배열로 바꾼 코드

```java
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long answer = 0;

        int delivery = 0;
        int pickup = 0;

        for (int i = n - 1; i >= 0; i--) {

            delivery += deliveries[i];
            pickup += pickups[i];

            int deliveryTrip = 0;
            int pickupTrip = 0;

            if (delivery > 0) {
                deliveryTrip = (delivery + cap - 1) / cap;
            }

            if (pickup > 0) {
                pickupTrip = (pickup + cap - 1) / cap;
            }

            int trips = Math.max(deliveryTrip, pickupTrip);

            if (trips > 0) {
                answer += (long) (i + 1) * 2 * trips;

                delivery -= trips * cap;
                pickup -= trips * cap;
            }
        }

        return answer;
    }
}
```

여기서 핵심은

```java
int trips = Math.max(deliveryTrip, pickupTrip);
```

이다.

한 번 멀리 갔다 오는 동안 **배달 `cap`개와 수거 `cap`개를 각각 처리할 수 있기 때문에**, 둘 중 더 많이 필요한 운행 횟수만큼 가면 된다.

그리고 이 방식은 배열을 뒤에서 앞으로 한 번만 확인하므로 **O(N)**으로 정리할 수 있다.
