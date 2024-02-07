import java.io.IOException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.io.BufferedWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        String inp[] = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);

        inp = br.readLine().split(" ");
        int ans = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int a = Integer.parseInt(inp[i]);
                    int b = Integer.parseInt(inp[j]);
                    int c = Integer.parseInt(inp[k]);
                    if (a + b + c <= M && a + b + c > ans) {
                        ans = a + b + c;
                    }

                }
            }
        }
        System.out.println(ans);
    }
}
