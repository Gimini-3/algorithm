import java.util.*;

class Solution {

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public int solution(int[][] land) {

        int answer = 0;

        int n = land.length;
        int m = land[0].length;

        int[][] visited = new int[n][m];
        int[] groupSize = new int[n * m + 1];

        Deque<Node> deque = new ArrayDeque<>();

        int level = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (land[i][j] == 1 && visited[i][j] == 0) {

                    deque.addLast(new Node(i, j));
                    visited[i][j] = level;
                    groupSize[level]++;

                    while (!deque.isEmpty()) {

                        Node now = deque.pollFirst();

                        for (int t = 0; t < 4; t++) {

                            int nextX = now.x + dx[t];
                            int nextY = now.y + dy[t];

                            if (nextX < 0 || nextX >= n ||
                                nextY < 0 || nextY >= m) {
                                continue;
                            }

                            if (land[nextX][nextY] == 0) {
                                continue;
                            }

                            if (visited[nextX][nextY] != 0) {
                                continue;
                            }

                            visited[nextX][nextY] = level;
                            groupSize[level]++;

                            deque.addLast(new Node(nextX, nextY));
                        }
                    }

                    level++;
                }
            }
        }

        for (int col = 0; col < m; col++) {

            Set<Integer> set = new HashSet<>();

            for (int row = 0; row < n; row++) {

                if (visited[row][col] != 0) {
                    set.add(visited[row][col]);
                }
            }

            int count = 0;

            for (int group : set) {
                count += groupSize[group];
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}