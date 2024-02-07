import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Long, long[]> hm = new HashMap<>();

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int inps[] = new int[N];
        String inp[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) inps[i] = Integer.parseInt(inp[i]);
        for (int i = 0; i < N - 1; i++) {
            int temp = inps[i] + inps[i + 1];
            inps[i + 1] = Integer.max(temp, inps[i + 1]);
        }
        int maxInt = -9999;
        for (int i = 0; i < N; i++) maxInt = Integer.max(maxInt, inps[i]);
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
