import java.io.IOException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.io.BufferedWriter;

import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        String inp = br.readLine();
        int R = Integer.parseInt(inp.split(" ")[0]);
        int C = Integer.parseInt(inp.split(" ")[1]);

        String field[] = new String[R];
        for (int i = 0; i < R; i++) {
            field[i] = br.readLine().stripTrailing();
        }

        inp = br.readLine();

        int A = Integer.parseInt(inp.split(" ")[0]);
        int B = Integer.parseInt(inp.split(" ")[1]);


        String ans[] = new String[R + R];

        for (int i = 0; i < R; i++) {
            StringBuffer sb = new StringBuffer(field[i]);
            ans[i] = field[i] + sb.reverse().toString();
        }

        for (int i = 0; i < R; i++) {
            ans[R + i] = ans[R - i - 1];
        }

        char point = ans[A - 1].charAt(B - 1);
        String before = ans[A - 1].substring(0, B - 1);
        String after = ans[A - 1].substring(B);
        if (point == '#') {
            ans[A - 1] = before + "." + after;
        } else {
            ans[A - 1] = before + "#" + after;
        }

        for (int i = 0; i < R * 2; i++) {
            System.out.println(ans[i]);
        }
    }
}
