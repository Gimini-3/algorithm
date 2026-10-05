# 구명보트

## 1. 생각 방식

먼저 사람들의 몸무게를 오름차순으로 정렬했다.

```java
Arrays.sort(people);
```

가장 가벼운 사람은 `left`, 가장 무거운 사람은 `right`로 두고 양쪽에서 확인했다.

```java
int left = 0;
int right = people.length - 1;
```

가장 가벼운 사람과 가장 무거운 사람을 같이 태울 수 있으면 둘을 한 보트에 태운다.

```java
if(people[left] + people[right] <= limit){
    left++;
    right--;
}
```

같이 탈 수 없다면 가장 무거운 사람은 혼자 타야 한다.

```java
else{
    right--;
}
```

### 왜 가장 무거운 사람과 가장 가벼운 사람을 비교하는가?

현재

```text
가장 가벼운 사람 + 가장 무거운 사람 > limit
```

이라면 가장 무거운 사람은 다른 누구와도 같이 탈 수 없다.

정렬되어 있어서 다른 사람들은 모두 `people[left]`보다 무겁거나 같기 때문이다.

```text
people[left] + people[right] > limit

→ 다른 사람 + people[right]도 무조건 limit 초과
```

그래서 이 경우 가장 무거운 사람을 혼자 보내도 된다.

반대로 둘이 같이 탈 수 있다면 가장 무거운 사람과 같이 탈 수 있는 사람 중 가장 가벼운 사람을 붙이는 것이 유리하다.

---

## 2. 자료구조 선택 이유

따로 자료구조를 추가하지 않고 정렬된 배열에서 `left`, `right` 두 인덱스를 사용하는 **투 포인터** 방식으로 풀었다.

```java
left  // 가장 가벼운 사람
right // 가장 무거운 사람
```

---

## 4. 시간복잡도

정렬하는 데

```text
O(N log N)
```

이 걸린다.

정렬 후에는 `left`, `right`가 한 방향으로만 움직이므로 `O(N)`이다.

따라서 전체 시간복잡도는 **O(N log N)**이다.

---

## 5. 코드 피드백

디버깅용

```java
System.out.println(people[0]);
```

은 제출할 때 제거하면 된다.

그리고 보트는 조건에 상관없이 한 번 반복할 때마다 한 대씩 사용하므로 `answer++`를 공통으로 빼도 된다.

현재 코드의

```java
if(people[left]+people[right]<=limit){
    answer++;
    left++;
    right--;
}else{
    answer+=1;
    right--;
}
```

를

```java
if(people[left] + people[right] <= limit){
    left++;
}

right--;
answer++;
```

처럼 줄일 수 있다.

### 정리한 전체 코드

```java
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {

        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while(left <= right){

            if(people[left] + people[right] <= limit){
                left++;
            }

            right--;
            answer++;
        }

        return answer;
    }
}
```

다만 `left == right`인 경우에도 `people[left] + people[right]`로 같은 사람을 두 번 더하게 되는데, 결과에는 문제 없지만 조금 더 명확하게 쓰고 싶으면 조건에 `left < right`를 추가할 수 있다.

```java
if(left < right && people[left] + people[right] <= limit){
    left++;
}
```

이렇게 쓰는 쪽이 의미상 더 깔끔하다.
