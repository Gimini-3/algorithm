# 롤케이크 자르기

## 1. 생각 방식

처음에는 모든 토핑을 `right`에 넣어서 오른쪽 조각이 가지고 있는 토핑 종류와 개수를 저장했다.

그다음 왼쪽부터 하나씩 토핑을 옮기면서

* `left`에는 현재 토핑을 추가하고
* `right`에서는 현재 토핑의 개수를 하나 감소시켰다.

```java
left.put(now, left.getOrDefault(now, 0) + 1);
```

오른쪽에 해당 토핑이 하나만 남아 있으면 더 이상 그 종류가 존재하지 않게 되므로 `remove()` 했다.

```java
if (right.get(now) == 1) {
    right.remove(now);
} else {
    right.put(now, right.get(now) - 1);
}
```

각 시점마다

```java
left.size()
right.size()
```

를 비교해서 양쪽의 토핑 종류 수가 같으면 공평하게 자른 것이므로 `answer`를 증가시켰다.

---

## 2. 자료구조 선택 이유

각 토핑의 **종류와 남아 있는 개수**를 같이 관리해야 해서 `HashMap<Integer, Integer>`를 사용했다.

`left.size()`와 `right.size()`를 통해 현재 양쪽에 존재하는 토핑 종류 수를 바로 구할 수 있다.

오른쪽에서는 토핑 개수가 0이 되면 `remove()`해서 `size()`가 실제 종류 수를 의미하도록 유지했다.

---

## 3. 기억할 문법

### `HashMap` 생성

```java
HashMap<Integer, Integer> map = new HashMap<>();
```

`key`와 `value`를 한 쌍으로 저장한다.

이 문제에서는

```text
key   = 토핑 번호
value = 해당 토핑의 개수
```

로 사용했다.

### `put()`

```java
map.put(key, value);
```

값을 저장하거나 기존 값을 변경한다.

### `get()`

```java
map.get(key);
```

해당 key의 value를 가져온다.

### `getOrDefault()`

```java
map.getOrDefault(key, 0)
```

key가 존재하면 해당 value를 반환하고, 없으면 두 번째 값인 `0`을 반환한다.

그래서 개수를 셀 때

```java
map.put(key, map.getOrDefault(key, 0) + 1);
```

처럼 많이 사용한다.

### `remove()`

```java
map.remove(key);
```

해당 key를 Map에서 제거한다.

### `size()`

```java
map.size();
```

현재 Map에 들어 있는 key의 개수를 반환한다.

이 문제에서는 곧 **토핑 종류 수**가 된다.

---

## 4. 시간복잡도

처음에 `right`에 모든 토핑을 넣으면서 `O(N)`.

그다음 토핑을 하나씩 `left`로 옮기는 과정도 `O(N)`이다.

`HashMap`의 `get`, `put`, `remove`는 평균 `O(1)`이므로 전체 시간복잡도는 **O(N)**이다.
