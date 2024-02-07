import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.*;
import java.lang.Math;


public class Main {
    static Map<String, Integer> hm = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(poluation(k, n));
        }

    }

    static public int poluation(int k, int n) {
        String key = Integer.toString(k) + "_" + Integer.toString(n);
        if (hm.containsKey(key)) {
            return hm.get(key);
        } else {
            if (k == 0) return n;
            if (n == 0) return 0;
            else {
                // cal P(k, n - 1)
                String subKey_1 = Integer.toString(k) + "_" + Integer.toString(n - 1);
                int subInt_1 = poluation(k, n - 1);
                hm.put(subKey_1, subInt_1);

                // cal P(k - 1, n)
                String subKey_2 = Integer.toString(k - 1) + "_" + Integer.toString(n);
                int subInt_2 = poluation(k - 1, n);
                hm.put(subKey_2, subInt_2);

                int ret = subInt_1 + subInt_2;
                hm.put(key, ret);

                return ret;
            }
        }
    }
}
