import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        String inp[] = br.readLine().split(" ");
        int E = Integer.parseInt(inp[0]) - 1, S = Integer.parseInt(inp[1]) - 1, M = Integer.parseInt(inp[2]) - 1;

        int targetNum = S;
        while (true) {
            int tE = targetNum % 15;
            int tM = targetNum % 19;
            if (tE == E && tM == M) break;
            targetNum += 28;
        }
        bw.write(Integer.toString(targetNum + 1) + "\n");

        bw.flush();
        bw.close();
    }
}
