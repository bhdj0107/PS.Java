import java.io.*;
import java.util.*;

import org.w3c.dom.Attr;

import java.lang.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] steps = new int[N];
        for (int i = 0; i < N; i++) steps[i] = Integer.parseInt(br.readLine());

        int[] oneSteps = new int[N];
        int[] twoSteps = new int[N];

        if (N == 1) {
            bw.write(steps[0] + "\n");
        } else {
            oneSteps[0] = steps[0];
            oneSteps[1] = steps[1];
            twoSteps[1] = steps[0] + steps[1];
            for (int i = 2; i < N; i++) {
                oneSteps[i] = Integer.max(twoSteps[i - 2], oneSteps[i - 2]) + steps[i];
                twoSteps[i] = oneSteps[i - 1] + steps[i];
            }
            bw.write(Integer.max(oneSteps[N - 1], twoSteps[N - 1]) + "\n");
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
