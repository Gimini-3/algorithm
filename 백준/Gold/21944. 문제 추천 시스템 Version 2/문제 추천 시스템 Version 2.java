import java.util.*;
import java.io.*;

class Main {


    public static Map<Integer, TreeMap<Integer, TreeSet<Integer>>> map = new HashMap<>();
    public static TreeMap<Integer, TreeSet<Integer>> map2 = new TreeMap<>();

    public static int n, m;
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    static final int MAX = 100000 + 5;
    public static int[] levelOf = new int[MAX];
    public static int[] algOf = new int[MAX];
    public static boolean[] alive = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int lev = Integer.parseInt(st.nextToken());
            int alg = Integer.parseInt(st.nextToken());
            add(num, lev, alg);
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            f(br.readLine());
        }

        System.out.print(sb);
    }

    public static void f(String str) {
        st = new StringTokenizer(str);
        String method = st.nextToken();

        switch (method) {
            case "add": {
                int num = Integer.parseInt(st.nextToken());
                int lev = Integer.parseInt(st.nextToken());
                int alg = Integer.parseInt(st.nextToken());
                add(num, lev, alg);
                break;
            }
            case "recommend": {
                int alg = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                recommend(alg, x);
                break;
            }
            case "recommend2": {
                int x = Integer.parseInt(st.nextToken());
                recommend2(x);
                break;
            }
            case "recommend3": {
                int x = Integer.parseInt(st.nextToken());
                int lev = Integer.parseInt(st.nextToken());
                recommend3(x, lev);
                break;
            }
            case "solved": {
                int num = Integer.parseInt(st.nextToken());
                solved(num);
                break;
            }
        }
    }

    public static void recommend(int alg, int x) {
        TreeMap<Integer, TreeSet<Integer>> tm = map.get(alg);
        if (tm == null || tm.isEmpty()) {
            sb.append(-1).append('\n');
            return;
        }

        if (x == 1) { 
            Map.Entry<Integer, TreeSet<Integer>> e = tm.lastEntry();
            sb.append(e.getValue().last()).append('\n');
        } else {
            Map.Entry<Integer, TreeSet<Integer>> e = tm.firstEntry();
            sb.append(e.getValue().first()).append('\n');
        }
    }

    public static void recommend2(int x) {
        if (map2.isEmpty()) {
            sb.append(-1).append('\n');
            return;
        }

        if (x == 1) {
            sb.append(map2.lastEntry().getValue().last()).append('\n');
        } else { 
            sb.append(map2.firstEntry().getValue().first()).append('\n');
        }
    }

    public static void recommend3(int x, int lev) {
        if (map2.isEmpty()) {
            sb.append(-1).append('\n');
            return;
        }

        if (x == 1) {
            Map.Entry<Integer, TreeSet<Integer>> e = map2.ceilingEntry(lev);
            if (e == null) sb.append(-1).append('\n');
            else sb.append(e.getValue().first()).append('\n');
        } else { 
            Map.Entry<Integer, TreeSet<Integer>> e = map2.lowerEntry(lev);
            if (e == null) sb.append(-1).append('\n');
            else sb.append(e.getValue().last()).append('\n');
        }
    }

    public static void solved(int num) {
        if (num <= 0 || num >= MAX) return;
        if (!alive[num]) return;

        alive[num] = false;
        int lev = levelOf[num];
        int alg = algOf[num];

        TreeMap<Integer, TreeSet<Integer>> tm = map.get(alg);
        if (tm != null) {
            TreeSet<Integer> set = tm.get(lev);
            if (set != null) {
                set.remove(num);
                if (set.isEmpty()) tm.remove(lev);
            }
            if (tm.isEmpty()) map.remove(alg);
        }

        TreeSet<Integer> setAll = map2.get(lev);
        if (setAll != null) {
            setAll.remove(num);
            if (setAll.isEmpty()) map2.remove(lev);
        }
    }

    public static void add(int num, int lev, int alg) {
        if (num <= 0 || num >= MAX) return;

        if (alive[num]) solved(num);

        alive[num] = true;
        levelOf[num] = lev;
        algOf[num] = alg;

        map.computeIfAbsent(alg, k -> new TreeMap<>())
           .computeIfAbsent(lev, k -> new TreeSet<>())
           .add(num);

        map2.computeIfAbsent(lev, k -> new TreeSet<>())
            .add(num);
    }
}