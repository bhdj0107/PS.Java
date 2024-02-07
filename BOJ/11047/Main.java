import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        String inp[] = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int total = Integer.parseInt(inp[1]);

        int coinsCnt = 0;
        int coins[] = new int[N];
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
            if (coins[i] <= total) coinsCnt += 1;
        }

        int ans = 0;
        for (int i = coinsCnt - 1; i > -1; i--) {
            if (total < 0) break;
            int divCnt = total / coins[i];
            if (divCnt > 0) {
                ans += divCnt;
                total -= coins[i] * divCnt;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
