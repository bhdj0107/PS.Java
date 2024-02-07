import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Main {
    static Map<String, Integer> hm = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

       int N = Integer.parseInt(br.readLine());

       System.out.println(fact(N));
    }

    static int fact(int N) {
        if (N == 0) return 1;
        int value = 1;
        for (int i = 1; i <= N; i++) {
            value *= i;
        }

        return value;
    }
}
