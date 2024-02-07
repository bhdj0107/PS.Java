import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        OutputStream out = System.out;
        OutputStreamWriter writer = new OutputStreamWriter(out);
        BufferedWriter bw = new BufferedWriter(writer);

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String inp[] = br.readLine().split(" ");
            int sumation = 0;
            sumation += Integer.parseInt(inp[0]);
            sumation += Integer.parseInt(inp[1]);
            bw.write(Integer.toString(sumation) + "\n");
        }
        bw.flush();
    }
}
