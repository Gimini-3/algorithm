import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        Set<String> used = new HashSet<>();

        int q = -1; // '?' 위치
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
            used.add(s[i]);
            if (s[i].equals("?")) q = i;
        }

        char start = ' '; 
        char end = ' ';  

        if (q > 0) {
            String prev = s[q - 1];
            start = prev.charAt(prev.length() - 1);
        }
        if (q < n - 1) {
            String next = s[q + 1];
            end = next.charAt(0);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String cand = br.readLine();
            if (used.contains(cand)) continue;

            boolean ok = true;
            if (start != ' ' && cand.charAt(0) != start) ok = false;
            if (end != ' ' && cand.charAt(cand.length() - 1) != end) ok = false;

            if (ok) {
                System.out.println(cand);
                return;
            }
        }
    }
}