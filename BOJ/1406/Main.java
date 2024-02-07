import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        String inp = br.readLine();
        int opCnt = Integer.parseInt(br.readLine());
        Deque<Character> dq = new LinkedList<>();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < inp.length(); i++) dq.addLast(inp.charAt(i));

        for (int i = 0; i < opCnt; i++) {
            String ops[] = br.readLine().split(" ");
            if (ops[0].equals("L")) {
                if (!dq.isEmpty()) stk.add(dq.pollLast());
            }
            else if (ops[0].equals("D")) {
                if (!stk.isEmpty()) dq.addLast(stk.pop());
            }
            else if (ops[0].equals("B")) {
                if (!dq.isEmpty()) dq.pollLast();
            }
            else if (ops[0].equals("P")) {
                dq.addLast(ops[1].charAt(0));
            }
        }
        while (!dq.isEmpty()) bw.write(dq.pollFirst());
        while (!stk.isEmpty()) bw.write(stk.pop());
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
