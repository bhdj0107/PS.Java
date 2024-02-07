import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Main {
    static Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

       int N = Integer.parseInt(br.readLine());

       System.out.println(fibo(N));
    }

    static int fibo(int N) {
        if (N == 0) return 0;
        else if (N == 1) return 1;
        else {
            if (hm.containsKey(N)) return hm.get(N);
            else {
                int fibo_N_minus_one = fibo(N - 1);
                int fibo_N_minus_two = fibo(N - 2);
                int fibo_N = fibo_N_minus_one + fibo_N_minus_two;
                hm.put(N, fibo_N);
                return fibo_N;
            }
        }
    }
}
