import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int inps[] = new int[N];
        for (int i = 0; i < N; i++) inps[i] = Integer.parseInt(br.readLine());

        HashSet<Integer> ans = findMeasures(Math.abs(inps[0] - inps[1]));

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int a = inps[i];
                int b = inps[j];

                HashSet<Integer> measures = findMeasures(Math.abs(a - b));
                ans.retainAll(measures);
            }
        }
        int finalInts[] = new int[ans.size() - 1];
        int cnt = 0;
        for (int i : ans) {
            if (i != 1) {
                finalInts[cnt++] = i;
            }
        }

        Arrays.sort(finalInts);
        for (int i = 0; i < finalInts.length - 1; i++) bw.write(finalInts[i] + " ");
        bw.write(finalInts[finalInts.length - 1] + "\n");
        bw.flush();
        bw.close();
    }

    public HashSet<Integer> findMeasures(int maximumMeasure) {
        HashSet<Integer> ret = new HashSet<>();
        int sqrt = (int)Math.sqrt(maximumMeasure) + 1;
        for (int i = 1; i < sqrt; i++) {
            if (maximumMeasure % i == 0) {
                int div = maximumMeasure / i;
                ret.add(i);
                ret.add(div);
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
