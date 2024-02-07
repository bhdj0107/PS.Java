import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;
import java.lang.Math;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        String inp[] = br.readLine().split(" ");
        int A = Integer.parseInt(inp[0]), B = Integer.parseInt(inp[1]);

        // 등차가 1인 수열의 N까지 합 = (N ** 2 + N) / 2
        int lN = (int)Math.ceil((Math.sqrt(1 + 8 * A) - 1) / 2);
        int rN = (int)Math.ceil((Math.sqrt(1 + 8 * B) - 1) / 2);
        int lNcnt = (lN * lN + lN) / 2;
        int rNcnt = (rN * rN + rN) / 2;

        int SumOfAll = 0;
        for (int i = lN + 1; i < rN + 1; i++) SumOfAll += i * i;

        SumOfAll += lN * (lNcnt + 1 - A);
        SumOfAll -= rN * (rNcnt - B);

        bw.write(Integer.toString(SumOfAll) + "\n");

        bw.flush();
        bw.close();
    }
}
