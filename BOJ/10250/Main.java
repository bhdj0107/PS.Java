import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String inp[] = br.readLine().split(" ");

            int H = Integer.parseInt(inp[0]);
            int W = Integer.parseInt(inp[1]);
            int N = Integer.parseInt(inp[2]);

            N += H;
            String floor;
            String room;
            if (N % H == 0) {
                floor = String.format("%d", H);
                room = String.format("%02d", (N - 1) / H);
            } else {
                floor = String.format("%d", N % H);
                room = String.format("%02d", N / H);
            }
            System.out.println(floor + room);
        }

    }
}
