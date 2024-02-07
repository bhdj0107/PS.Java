import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int w[] = new int[N];
        String inp[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) w[i] = Integer.parseInt(inp[i]);
        Arrays.sort(w);
        for (int i = 0; i < N - 1; i++) {
            w[N - 1] += w[i] * (N - i);
        }
        bw.write(w[N - 1] + "\n");
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
