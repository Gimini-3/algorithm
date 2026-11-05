# 타겟 넘버

## 1. 생각 방식

각 숫자마다 `+`를 붙이는 경우와 `-`를 붙이는 경우 두 가지가 있으므로 DFS로 모든 경우를 확인했다.

현재 숫자를 더한 뒤 다음 숫자로 넘어간다.

```java
sum += val;
dfs(idx + 1);
```

다시 원래 상태로 돌린 뒤 이번에는 현재 숫자를 빼고 다음 숫자로 넘어간다.

```java
sum -= val;
sum -= val;
dfs(idx + 1);
sum += val;
```

모든 숫자를 사용한 경우

```java
if(idx == len)
```

현재 합이 `target`과 같으면 `answer`를 증가시킨다.

```java
if(sum == target2) answer++;
```

즉 각 숫자마다

```text
+ 선택
- 선택
```

두 갈래로 계속 탐색하는 완전탐색 문제다.

## 2. 자료구조 선택 이유

따로 자료구조는 필요하지 않았다.

현재 몇 번째 숫자인지 `idx`, 현재까지 만든 값은 `sum`으로 관리하면서 DFS로 탐색했다.

## 4. 시간복잡도

숫자 하나마다 `+`, `-` 두 가지 경우가 생긴다.

숫자가 `N`개라면 경우의 수는

```text
2^N
```

이므로 시간복잡도는 **O(2^N)**이다.

재귀 깊이는 최대 `N`이므로 재귀 스택 공간은 **O(N)**이다.

## 5. 코드 피드백

현재 코드의

```java
sum += val;
dfs(idx + 1);

sum -= val;

sum -= val;
dfs(idx + 1);

sum += val;
```

도 정상적으로 동작한다.

다만 `sum`을 전역 변수로 두다 보니 `+val`, `-val`로 원상복구하는 부분을 계속 신경 써야 한다.

이 문제는 현재 합을 DFS 인자로 넘기면 훨씬 간단하게 작성할 수 있다.

```java
dfs(idx + 1, sum + numbers[idx]);
dfs(idx + 1, sum - numbers[idx]);
```

그러면 `sum`을 직접 복구할 필요도 없고 `numbers2`, `len`, `target2` 같은 전역 변수도 줄일 수 있다.

### 수정한 전체 코드

```java
class Solution {

    int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(0, 0, numbers, target);

        return answer;
    }

    public void dfs(int idx, int sum, int[] numbers, int target) {

        if(idx == numbers.length){

            if(sum == target){
                answer++;
            }

            return;
        }

        dfs(idx + 1, sum + numbers[idx], numbers, target);
        dfs(idx + 1, sum - numbers[idx], numbers, target);
    }
}
```

이 문제에서는 **각 숫자마다 `+ / -` 두 가지 선택지를 DFS로 모두 탐색한다**는 것만 잡으면 돼.
