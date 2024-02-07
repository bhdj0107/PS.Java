import java.io.*;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        String inp[] = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]), K = Integer.parseInt(inp[1]);
        boolean maskingArray[] = new boolean[N + 1];
        int now = 0;
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (maskingArray[i]) continue;
            now = i;
            cnt += 1;
            if (cnt == K) break;
            for (int j = 2; j < N; j++) {
                int tNow = i * j;
                if (tNow > N) break;
                if (maskingArray[tNow]) continue;
                now = tNow;
                cnt += 1;
                maskingArray[now] = true;
                if (cnt == K) break;
            }
            if (cnt == K) break;
        }

        bw.write(Integer.toString(now) + "\n");
        bw.flush();
        bw.close();
    }
}
