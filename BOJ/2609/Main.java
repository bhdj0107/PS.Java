import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        String inp[] = br.readLine().split(" ");
        int A = Integer.parseInt(inp[0]), B = Integer.parseInt(inp[1]);
        int gcd = GCD(A, B);

        int A_G = A / gcd;
        System.out.println(gcd);
        System.out.println(B * A_G);
    }

    static int GCD(int a, int b) {
        int little = Integer.min(a, b);
        int big = Integer.max(a, b);
        if (little == 0) return big;
        else return GCD(little, big % little);
    }
}
