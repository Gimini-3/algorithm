# 오픈채팅방

## 1. 생각 방식

`record`를 처음부터 돌면서 **현재 유저의 최종 닉네임**을 `HashMap`에 저장했다.

```java
id → nickname
```

`Enter`가 나오면 입장 기록을 저장하고 닉네임을 갱신했다.

`Leave`는 출력할 기록만 저장했다.

`Change`는 출력되는 메시지는 없고 닉네임만 변경했다.

```java
Enter  → 기록 저장 + 닉네임 갱신
Leave  → 기록 저장
Change → 닉네임 갱신
```

모든 `record`를 처리하고 나면 `map`에는 각 id의 **최종 닉네임**이 남는다.

그다음 저장해둔 `Enter`, `Leave` 기록을 순서대로 돌면서 최종 닉네임으로 메시지를 만들었다.

---

## 2. 자료구조 선택 이유

유저 id로 최종 닉네임을 바로 찾아야 해서 `HashMap<String, String>`을 사용했다.

```java
HashMap<String, String> map
```

출력해야 하는 `Enter`, `Leave` 기록의 순서를 유지해야 해서 `List<Node>`에 저장했다.

```java
List<Node> li = new ArrayList<>();
```

`Node`에는

```java
명령어 종류 + 유저 id
```

만 저장하고, 닉네임은 마지막에 `map`에서 가져왔다.

---

## 4. 시간복잡도

`record`를 한 번 돌고, 출력할 기록을 한 번 더 돈다.

`HashMap` 조회와 저장은 평균 `O(1)`이므로 전체 시간복잡도는 **O(N)**이다.

---

## 5. 코드 피드백

`Enter`에서

```java
if(!map.containsKey(id)){
    map.put(id,name);
}else{
    String now = map.get(id);
    if(!now.equals(name)){
        map.put(id,name);
    }
}
```

까지 확인할 필요는 없다.

`HashMap.put()`은 이미 같은 key가 있으면 기존 value를 덮어쓰므로 그냥

```java
map.put(id, name);
```

하면 된다.

`Change`도 마찬가지로 바로 갱신하면 된다.

```java
map.put(id, name);
```

그리고

```java
String[] answer = {};
```

는 처음에는 필요 없고, `li`를 다 만든 다음 크기를 정해서 생성하면 된다.

### 정리한 전체 코드

```java
import java.util.*;

class Solution {

    public String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();
        List<Node> li = new ArrayList<>();

        StringTokenizer st;

        for(int i = 0; i < record.length; i++){

            st = new StringTokenizer(record[i]);

            String con = st.nextToken();
            String id = st.nextToken();

            String name = "";

            if(!con.equals("Leave")){
                name = st.nextToken();
            }

            switch(con){

                case "Enter":
                    li.add(new Node(con, id));
                    map.put(id, name);
                    break;

                case "Leave":
                    li.add(new Node(con, id));
                    break;

                case "Change":
                    map.put(id, name);
                    break;
            }
        }

        String[] answer = new String[li.size()];

        for(int i = 0; i < li.size(); i++){

            Node now = li.get(i);

            String nowName = map.get(now.id);

            StringBuilder sb = new StringBuilder();

            sb.append(nowName).append("님이");

            switch(now.x){

                case "Enter":
                    sb.append(" 들어왔습니다.");
                    break;

                case "Leave":
                    sb.append(" 나갔습니다.");
                    break;
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    public class Node {

        String x;
        String id;

        public Node(String x, String id){
            this.x = x;
            this.id = id;
        }
    }
}
```

핵심은 **이벤트에는 id만 저장하고, 모든 기록을 처리한 뒤 최종 닉네임을 Map에서 가져오는 것**이다.
