import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        String inp[] = br.readLine().split(" ");
        int A = Integer.parseInt(inp[0]), B = Integer.parseInt(inp[1]);
        for (int i = A; i <= B; i++) {
            if (isPrime(i)) bw.write(Integer.toString(i) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static boolean isPrime(int N) {
        if (N == 1) return false;
        if (N == 2) return true;
        else {
            int sqrtN = (int)Math.sqrt(N) + 1;
            for (int i = sqrtN; i > 1; i--) {
                if (N % i == 0) return false;
            }
            return true;
        }
    }

}
