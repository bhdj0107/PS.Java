import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int trees[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());
        long minLen = 0;
        long maxLen = Integer.MAX_VALUE;

        while (true) {
            long halfLen = ((maxLen + minLen) / 2);
            if (halfLen == minLen) break;
            long tempN = 0;
            for (int i = 0; i < N; i++) {
                long cutLen = trees[i] - halfLen;
                if (cutLen > 0) tempN += cutLen;
            }
            if (tempN >= M) {
                minLen = halfLen;
            } else if (tempN < M) {
                maxLen = halfLen;
            }
        }

        bw.write(minLen + "\n");
        bw.flush();
        bw.close();
    }

}
