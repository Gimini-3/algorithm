import java.util.*;
import java.io.*;

class Main {
    // 0:↗ 1:↘ 2:→ 3:↓ 4:↙ 5:↖ 6:← 7:↑
    public static int dx[] = new int[]{-1, 1, 0, 1, 1, -1, 0, -1};
    public static int dy[] = new int[]{ 1, 1, 1, 0,-1, -1,-1,  0};

    public static int[][] arr = new int[20][20];

    public static int swi = 0;
    public static int ansX = -1;
    public static int ansY = -1;
    public static int ansCol = 0;

    public static int X;
    public static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (arr[i][j] == 0) continue;

                // 4방향만 검사 (↗,↘,→,↓)
                for (int dir = 0; dir < 4; dir++) {

                    int px = i - dx[dir];
                    int py = j - dy[dir];
                    if (inRange(px, py) && arr[px][py] == arr[i][j]) continue;

                    X = i;
                    Y = j;
                    f(i, j, arr[i][j], 1, dir);

                    if (swi == 1) {
                        System.out.println(ansCol);
                        System.out.println(ansX + " " + ansY);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static boolean inRange(int x, int y) {
        return (x >= 1 && y >= 1 && x <= 19 && y <= 19);
    }

    // col 1: black, 2: white
    // lev : 1~5
    // dir : 방향
    public static void f(int x, int y, int col, int lev, int dir) {
        if (!inRange(x, y)) return;

        int now = arr[x][y];
        if (now != col) return;

    
        if (lev == 5) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (inRange(nx, ny) && arr[nx][ny] == col) return;

            swi = 1;
            ansX = X;
            ansY = Y;
            ansCol = col;
            return;
        }

        f(x + dx[dir], y + dy[dir], col, lev + 1, dir);
    }
}