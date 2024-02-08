import java.util.*;
import java.io.*;
class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int DP[][] = new int[N][2];
        // DP[i][0] == 사자를 놓지 않는 경우
        // DP[i][1] == 사자를 왼쪽 or 오른쪽에 놓는 경우

        DP[0][0] = 1;
        DP[0][1] = 1;

        for (int i = 1; i < N; i++) {
            DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] * 2) % 9901;
            DP[i][1] = (DP[i - 1][0] + DP[i - 1][1]) % 9901;
        }

        bw.write((DP[N - 1][0] + DP[N - 1][1] * 2) % 9901 + "\n");
        bw.flush();
        bw.close();
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        Solution s = new Solution();
        s.solution();
    }
}