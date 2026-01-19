import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] stack = new char[s.length()];
        int top = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack[top++] = c;

            if (top >= 4
                    && stack[top - 4] == 'P'
                    && stack[top - 3] == 'P'
                    && stack[top - 2] == 'A'
                    && stack[top - 1] == 'P') {
                top -= 3;
            }
        }

        if (top == 1 && stack[0] == 'P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}
