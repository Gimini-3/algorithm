# 모의고사

## 1. 생각 방식

수포자 3명의 찍는 패턴을 각각 배열로 만들었다.

각 문제를 돌면서 현재 문제 번호 `i`에 맞는 답을 패턴에서 가져와 실제 정답이랑 비교했다.

패턴 길이가 다르기 때문에 `%`를 사용해서 반복되게 만들었다.

```java
one[i % one.length]
two[i % two.length]
three[i % three.length]
```

맞힌 개수는 `cnt` 배열에 저장했다.

```java
cnt[0] // 1번
cnt[1] // 2번
cnt[2] // 3번
```

그다음 3명 중 가장 높은 점수 `max`를 구하고, `max`와 같은 사람 수를 먼저 구해서 `answer` 배열 크기를 정했다.

마지막으로 1번부터 순서대로 확인하면서 최고 점수인 사람을 `answer`에 넣었다.

이 순서대로 넣기 때문에 동점이어도 자동으로 오름차순이 된다.

## 2. 자료구조 선택 이유

수포자마다 찍는 패턴이 정해져 있어서 각각 `int[]` 배열로 저장했다.

```java
int[] one
int[] two
int[] three
```

각 수포자의 점수도 3명으로 고정되어 있어서

```java
int[] cnt = new int[3];
```

으로 관리했다.

## 4. 시간복잡도

`answers`를 한 번 순회하고 마지막에는 3명만 확인한다.

따라서 전체 시간복잡도는

```text
O(N)
```

이다.

## 5. 코드 피드백

현재 코드는 문제 크기도 작고 흐름도 단순해서 그대로 써도 된다.

다만

```java
int size = 0;

for(int i=0;i<3;i++){
    if(cnt[i]==max){
        size++;
    }
}
```

로 배열 크기를 먼저 구한 뒤 다시 한 번 순회하고 있다.

`ArrayList<Integer>`에 최고 점수인 사람을 바로 넣고 마지막에 `int[]`로 바꾸는 방법도 있다.

다만 지금 방식은 `ArrayList → int[]` 변환이 필요 없어서 오히려 문법적으로는 더 단순하다.

### 정리한 전체 코드

```java
class Solution {
    public int[] solution(int[] answers) {

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int[] cnt = new int[3];

        for(int i=0;i<answers.length;i++){

            if(answers[i] == one[i % one.length]){
                cnt[0]++;
            }

            if(answers[i] == two[i % two.length]){
                cnt[1]++;
            }

            if(answers[i] == three[i % three.length]){
                cnt[2]++;
            }
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

        int size = 0;

        for(int i=0;i<3;i++){
            if(cnt[i] == max){
                size++;
            }
        }

        int[] answer = new int[size];
        int index = 0;

        for(int i=0;i<3;i++){
            if(cnt[i] == max){
                answer[index] = i + 1;
                index++;
            }
        }

        return answer;
    }
}
```

이 문제에서는 **반복 패턴을 `%`로 처리하는 부분**이 핵심이다.
