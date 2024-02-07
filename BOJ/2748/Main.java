import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Long, Long> hm = new HashMap<>();

    public void solution() throws IOException{
        Long N = Long.parseLong(br.readLine());
        bw.write(fibo(N) + "\n");
        bw.flush();
        bw.close();
    }

    public Long fibo(Long n) {
        if (n == 0) return (long)0;
        else if (n == 1) return (long)1;
        else {
            if (hm.containsKey(n)) return hm.get(n);
            else {
                Long a = fibo(n - 2);
                Long b = fibo(n - 1);
                hm.put(n, a + b);
                return a + b;
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
