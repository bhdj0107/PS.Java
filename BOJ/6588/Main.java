import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Integer, Boolean> hm = new HashMap<>();
    public void solution() throws IOException{
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            boolean chk = false;
            int a = 0;
            int b = 0;
            for (int i = 3; i <= N / 2; i += 2) {
                a = i;
                b = N - i;
                chk = isPrime(b) && isPrime(a);
                if (chk) break;
            }
            if (chk) bw.write(N + " = " + a + " + " + b + "\n");
            else bw.write("Goldbach's conjecture is wrong.\n");
        }
        bw.flush();
        bw.close();
    }


    public boolean isPrime(int n) {
        if (hm.containsKey(n)) return hm.get(n);
        if (n == 1) return false;
        else if (n == 2) return true;
        int sqrt = (int)Math.sqrt(n) + 1;
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                hm.put(n, false);
                return false;
            }
        }
        hm.put(n, true);
        return true;
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
