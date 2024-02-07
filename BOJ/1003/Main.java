import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Long, long[]> hm = new HashMap<>();

    public void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            long[] ans = fibo(N);
            bw.write(ans[0] + " " + ans[1] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public long[] fibo(Long n) {
        if (n == 0) {
            long[] ret = {1, 0};
            return ret;
        }
        else if (n == 1) {
            long[] ret = {0, 1};
            return ret;
        }
        else {
            if (hm.containsKey(n)) return hm.get(n);
            else {
                long[] a = fibo(n - 2);
                long[] b = fibo(n - 1);
                long[] tmp = new long[2];
                tmp[0] = a[0] + b[0];
                tmp[1] = a[1] + b[1];
                hm.put(n, tmp);
                return tmp;
            }
        }
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
