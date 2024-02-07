import java.io.IOException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.io.BufferedWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        int score[] = new int[10];
        for (int i = 0; i < 10; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        int before = 0;
        int total = 0;
        for (int i = 0; i < 10; i++) {
            int value = score[i];
            before = total;
            total += value;
            if (total > 100) break;
        }

        int absbef = Math.abs(before - 100);
        int abstotal = Math.abs(total - 100);

        if (absbef < abstotal) {
            System.out.println(before);
        } else {
            System.out.println(total);
        }
    }
}
