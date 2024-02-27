import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            long dist = end - start;
            if (dist == 1) {
                bw.write("1\n");
                continue;
            }
            double sqrt = Math.sqrt(4 * dist + 5) / 2;
            double sqrtMinus = sqrt - 3/2.;
            int minStep = (int)Math.ceil(sqrtMinus);
            long leftDist = dist - (minStep * (minStep + 1));
            int ans;
            if (leftDist > minStep + 1) ans = minStep * 2 + 2;
            else if (leftDist == 0) ans = minStep * 2;
            else ans = minStep * 2 + 1;
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}