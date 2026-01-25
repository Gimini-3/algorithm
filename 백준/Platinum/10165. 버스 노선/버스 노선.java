import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<node> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x <= y) {
                list.add(new node(i+1, x, y));
                list.add(new node(i+1, x + n, y + n));
            } else {
                // 펼침
                list.add(new node(i+1, x, y + n));
            }
        }

        // 정렬: start 오름차순, end 내림차순
        list.sort((node1, node2) -> {
            if (node1.start != node2.start) return Integer.compare(node1.start, node2.start);
            if (node1.end != node2.end) return Integer.compare(node2.end, node1.end);
            return Integer.compare(node1.num, node2.num);
        });
      //  for(node no:list){
    //        System.out.println(no.start+" "+no.end);
    //    }
        boolean[] removed = new boolean[m + 1];
        int now_end = -1;

        for (node no : list) {
            if (no.end <= now_end) {
                removed[no.num] = true; 
            } else {
                now_end = no.end;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num = 1; num <= m; num++) {
            if (!removed[num]) result.add(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(result.get(i));
        }
        System.out.println(sb);
    }

    public static class node {
        public int num;
        public int start;
        public int end;

        public node(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }
}
