import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String keylog = br.readLine();
            Deque<Character> dq = new LinkedList<>();
            Stack<Character> stk = new Stack<>();

            for (int i = 0; i < keylog.length(); i++) {
                char c = keylog.charAt(i);
                if (c == '<') {
                    if (!dq.isEmpty()) {
                        stk.add(dq.pollLast());
                    }
                } else if (c == '>') {
                    if (!stk.isEmpty()) {
                        dq.addLast(stk.pop());
                    }
                } else if (c == '-') {
                    if (!dq.isEmpty()) dq.pollLast();
                } else if (isAlpha(c) || isNumber(c)) dq.addLast(c);
            }
            while (!dq.isEmpty()) {
                bw.write(dq.pollFirst());
            }

            while (!stk.isEmpty()) {
                bw.write(stk.pop());
            }

            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static boolean isAlpha(char c) {
        if ('a' <= c && c <= 'z') return true;
        else if ('A' <= c && c <= 'Z') return true;
        else return false;
    }

    static boolean isNumber(char c) {
        if ('0' <= c && c <= '9') return true;
        else return false;
    }
}
