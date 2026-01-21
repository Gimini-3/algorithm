import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 가로(x)
        int R = Integer.parseInt(st.nextToken()); // 세로(y)
        int num = Integer.parseInt(br.readLine());

        if (num > C * R) {
            System.out.println(0);
            return;
        }

        // 좌표: (1,1)에서 시작, 위로 증가하는 y 좌표계
        int x = 1, y = 1;

        // 방향: 위, 오른쪽, 아래, 왼쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;

        // 경계: left~right, bottom~top
        int left = 1, right = C, bottom = 1, top = R;

        for (int k = 1; k < num; k++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 다음 칸이 경계를 벗어나면 지금 방향 끝까지 옴
            if (nx < left || nx > right || ny < bottom || ny > top) {
                if (dir == 0) left++;        
                else if (dir == 1) top--;   
                else if (dir == 2) right--;  
                else bottom++;              

                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}