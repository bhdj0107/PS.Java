import java.util.*;

import java.io.*;
import java.math.BigInteger;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) - 1;
        int r = Integer.parseInt(st.nextToken()) - 1;

        bw.write(combination(N, r).toString() + "\n");
        bw.flush();
        bw.close();
    }

    public static BigInteger combination(int n, int r) {
        BigInteger ans = new BigInteger("1");
        for (int i = 0; i < r; i++) {
            ans = ans.multiply(new BigInteger((n - i) + ""));
        }
        for (int i = 1; i <= r; i++) {
            ans = ans.divide(new BigInteger(i + ""));
        }
        return ans;
    }
}