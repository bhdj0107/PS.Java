import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int inps[] = new int[N];
        String inp[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) inps[i] = Integer.parseInt(inp[i]);

        int ans[] = new int[N];
        Arrays.fill(ans, 1);

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (inps[j] > inps[i]) ans[j] = Integer.max(ans[j], ans[i] + 1);
            }
        }
        int maxInt = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) maxInt = Integer.max(maxInt, ans[i]);
        bw.write(maxInt + "\n");
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
