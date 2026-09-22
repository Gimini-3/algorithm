# 호텔 대실

## 1. 생각 방식

먼저 예약을 **시작 시간 기준으로 정렬**했다.

각 예약의 시작 시간과 종료 시간을 분 단위로 바꿔서 계산했다.

```java
int total1 = Integer.parseInt(str1[0]) * 60
           + Integer.parseInt(str1[1]);

int total2 = Integer.parseInt(str2[0]) * 60
           + Integer.parseInt(str2[1]);
```

`PriorityQueue`에는 현재 사용 중인 방들의 **종료 시간**을 넣었다.

가장 빨리 끝나는 방을 `pq.peek()`으로 확인해서, 청소 시간 10분까지 지난 뒤 현재 예약을 받을 수 있으면 기존 방을 다시 사용했다.

```java
if(pq.peek() + 10 <= total1){
    pq.poll();
}
```

아직 사용할 수 있는 방이 없으면 새로운 방이 필요하므로 `answer`를 증가시켰다.

```java
else {
    answer++;
}
```

처음 예약을 받을 때도 방이 하나 필요하므로 `answer++` 하고, 현재 예약의 종료 시간을 Queue에 넣었다.

결국 예약을 순서대로 보면서 **기존 방을 재사용할 수 있는지 확인하고, 안 되면 방을 하나 추가하는 방식**으로 풀었다.

## 2. 자료구조 선택 이유

현재 사용 중인 방 중에서 **가장 빨리 끝나는 방을 먼저 확인해야 해서 `PriorityQueue`**를 사용했다.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

종료 시간이 가장 작은 값이 항상 `pq.peek()`에 있기 때문에 현재 예약에서 방을 재사용할 수 있는지 바로 확인할 수 있다.


## 3. 시간복잡도

예약을 시작 시간 기준으로 정렬하는 데 `O(N log N)`이 걸린다.

각 예약마다 `PriorityQueue`의 `poll()`, `add()`를 사용하므로 `O(log N)`씩 걸린다.

따라서 전체 시간복잡도는 **O(N log N)**이다.
