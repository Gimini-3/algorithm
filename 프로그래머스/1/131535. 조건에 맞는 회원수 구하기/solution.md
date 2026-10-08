# 2021년에 가입한 20대 회원 수 구하기

## 1. 생각 방식

`USER_INFO` 테이블에서 조건에 맞는 회원만 걸러낸 뒤 `COUNT(*)`로 인원 수를 구했다.

조건은 두 가지다.

- 가입일이 2021년
- 나이가 20세 이상 29세 이하

```sql
WHERE JOINED >= '2021-01-01'
  AND JOINED < '2022-01-01'
  AND AGE BETWEEN 20 AND 29
```

마지막으로 조건을 만족하는 행의 개수를 `USERS`라는 이름으로 반환했다.

```sql
COUNT(*) AS USERS
```

## 2. 문법

### `BETWEEN`

```sql
AGE BETWEEN 20 AND 29
```

아래와 같은 의미다.

```sql
AGE >= 20 AND AGE <= 29
```

양쪽 끝값인 `20`, `29`도 포함한다.

### 날짜 범위

```sql
JOINED >= '2021-01-01'
AND JOINED < '2022-01-01'
```

2021년 1월 1일부터 2022년 1월 1일 직전까지 조회한다.

`JOINED`에 시간이 포함되어 있어도 안전하게 2021년 전체를 조회할 수 있다.

## 3. 코드 피드백

지금 쿼리 그대로 깔끔하다.

특히 날짜를

```sql
JOINED BETWEEN '2021-01-01' AND '2021-12-31'
```

보다

```sql
JOINED >= '2021-01-01'
AND JOINED < '2022-01-01'
```

로 작성한 게 더 좋다. `DATETIME`처럼 시간까지 저장되는 컬럼에서도 마지막 날 데이터가 빠질 문제가 없다.

### 정리한 전체 코드

```sql
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE JOINED >= '2021-01-01'
  AND JOINED < '2022-01-01'
  AND AGE BETWEEN 20 AND 29;
```
