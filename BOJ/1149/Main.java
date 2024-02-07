import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int inps[][] = new int[N][3];
        for (int i = 0; i < N; i++) {
            String t[] = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) inps[i][j] = Integer.parseInt(t[j]);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int left = inps[i - 1][(j + 1) % 3];
                int right = inps[i - 1][(j + 2) % 3];
                inps[i][j] += Integer.min(left, right);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Integer.min(inps[N - 1][i], ans);
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
