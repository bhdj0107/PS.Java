import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int lines[] = new int[K];

        for (int i = 0; i < K; i++) lines[i] = Integer.parseInt(br.readLine());
        long minLen = 1;
        long maxLen = Integer.MAX_VALUE;
        maxLen += 1;

        while (true) {
            long halfLen = ((maxLen + minLen) / 2);
            if (halfLen == minLen) break;
            long tempN = 0;
            for (int i = 0; i < K; i++) tempN += lines[i] / halfLen;
            if (tempN >= N) {
                minLen = halfLen;
            } else if (tempN < N) {
                maxLen = halfLen;
            }
        }

        bw.write(minLen + "\n");
        bw.flush();
        bw.close();
    }

}