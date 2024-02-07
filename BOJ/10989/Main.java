import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int cnt[] = new int[10001];
        for (int i = 0; i < N; i++) cnt[Integer.parseInt(br.readLine())] += 1;
        for (int i = 0; i < 10001; i++) {
            if (cnt[i] > 0) {
                String output = i + "\n";
                for (int j = 0; j < cnt[i]; j++) bw.write(output);
            }
        }
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
