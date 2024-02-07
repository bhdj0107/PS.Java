import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        String inp[] = br.readLine().split(" ");
        int A, B, V;

        A = Integer.parseInt(inp[0]);
        B = Integer.parseInt(inp[1]);
        V = Integer.parseInt(inp[2]);

        int V_A = V - A;
        int A_B = A - B;

        int Jumps = V_A / A_B + 1;
        if (V_A % A_B > 0) Jumps += 1;
        System.out.println(Jumps);
    }
}
