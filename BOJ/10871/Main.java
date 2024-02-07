import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        String inp[] = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int X = Integer.parseInt(inp[1]);

        inp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int nowInt = Integer.parseInt(inp[i]);
            if (nowInt < X) {
                System.out.printf("%d ", nowInt);
            }
        }
    }
}
