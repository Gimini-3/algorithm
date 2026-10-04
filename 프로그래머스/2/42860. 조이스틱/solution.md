# 조이스틱

## 1. 생각 방식

조이스틱 이동을 **알파벳 변경 횟수 + 커서 이동 횟수**로 나눠서 계산했다.

먼저 각 문자에서 `A`부터 위로 가는 경우와 아래로 가는 경우 중 작은 값을 더했다.

```java
int val = name.charAt(i) - 'A';
answer += Math.min(val, 26 - val);
```

커서 이동은 기본적으로 오른쪽으로 끝까지 가는 경우로 잡았다.

```java
int move = len - 1;
```

그다음 현재 위치 `i` 뒤에 연속된 `A`가 몇 개 있는지 확인했다.

```java
int next = i + 1;

while(next < len && name.charAt(next) == 'A'){
    next++;
}
```

`A`는 변경할 필요가 없기 때문에 이 구간을 굳이 끝까지 지나가지 않고 **중간에서 방향을 바꾸는 경우**를 확인했다.

오른쪽으로 갔다가 다시 왼쪽으로 돌아가는 경우:

```java
int right = i * 2 + (len - next);
```

```text
0 → i까지 이동
i → 0으로 다시 이동
맨 뒤쪽 → next까지 이동
```

그래서

```text
i + i + (len - next)
```

가 된다.

반대로 왼쪽 부분을 먼저 더 많이 이동하는 경우:

```java
int left = i + (len - next) * 2;
```

두 경우와 기존 `move` 중 가장 작은 값을 계속 저장했다.

```java
move = Math.min(move, right);
move = Math.min(move, left);
```

마지막에 문자 변경 횟수와 커서 이동 횟수를 더했다.

```java
answer += move;
```

## 2. 자료구조 선택 이유

따로 자료구조는 사용하지 않았다.

문자열을 한 글자씩 확인하면서 알파벳 변경 횟수와 커서 이동 횟수만 계산하면 되기 때문에 변수만 사용했다.

## 4. 시간복잡도

문자열을 한 번 순회하지만 각 위치에서 연속된 `A`를 다시 확인한다.

```java
while(next < len && name.charAt(next) == 'A')
```

때문에 최악의 경우 시간복잡도는 **O(N²)**이다.

## 5. 코드 피드백

알파벳 이동과 좌우 이동을 따로 계산한 방식은 그대로 가져가면 된다.

특히 이 문제에서 어려운 부분은

```java
int right = i * 2 + (len - next);
int left = i + (len - next) * 2;
```

처럼 **연속된 `A` 구간을 만나면 방향을 바꾸는 경우까지 확인하는 것**이다.

`move` 갱신은 두 번 나눠 쓰지 않고 한 번에 써도 된다.

```java
move = Math.min(move, Math.min(right, left));
```

디버깅용 `System.out.println()` 주석은 최종 코드에서는 지워도 된다.

### 정리한 전체 코드

```java
class Solution {
    public int solution(String name) {

        int answer = 0;
        int len = name.length();

        int move = len - 1;

        for(int i = 0; i < len; i++){

            // 알파벳 변경
            int val = name.charAt(i) - 'A';
            answer += Math.min(val, 26 - val);

            // 현재 위치 뒤의 연속된 A 확인
            int next = i + 1;

            while(next < len && name.charAt(next) == 'A'){
                next++;
            }

            // 오른쪽으로 갔다가 다시 돌아오는 경우
            int right = i * 2 + (len - next);

            // 왼쪽 방향을 더 많이 사용하는 경우
            int left = i + (len - next) * 2;

            move = Math.min(
                move,
                Math.min(right, left)
            );
        }

        answer += move;

        return answer;
    }
}
```

핵심은 **상하 이동은 각 문자마다 최소값을 구하고, 좌우 이동은 연속된 `A`를 기준으로 방향을 꺾는 경우까지 비교하는 것**이다.
