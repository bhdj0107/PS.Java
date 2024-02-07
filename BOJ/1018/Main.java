import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);
    static String Field[] = new String[51];

    public static void main(String[] args) throws IOException {
        String inp[] = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]), M = Integer.parseInt(inp[1]);
        int minCount = 65;
        for (int i = 0; i < N; i++) Field[i] = br.readLine();

        for (int i = 0; i < N - 7 && minCount != 0; i++) {
            for (int j = 0; j < M - 7 && minCount != 0; j++) {
                minCount = Integer.min(FieldMinCount(i, j), minCount);
            }
        }

        bwPrintln(minCount);

        bw.flush();
        bw.close();
    }

    static int FieldMinCount(int y, int x) {
        int minCount = 65;

        // if left top is "W"
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // if that cell must be "W"
                if ((i + j) % 2 == 0) {
                    if (Field[y + i].charAt(x + j) != 'W') count += 1;
                }
                // else that cell must be "B"
                else {
                    if (Field[y + i].charAt(x + j) != 'B') count += 1;
                }
            }
        }
        minCount = Integer.min(minCount, count);

        // if left top is "B"
        count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // if that cell must be "W"
                if ((i + j) % 2 == 0) {
                    if (Field[y + i].charAt(x + j) != 'B') count += 1;
                }
                // else that cell must be "B"
                else {
                    if (Field[y + i].charAt(x + j) != 'W') count += 1;
                }
            }
        }
        minCount = Integer.min(minCount, count);

        return minCount;
    }

    static void bwPrintln(String s) throws IOException {
        bw.write(s + "\n");
    }

    static void bwPrintln(int i) throws IOException {
        bw.write(Integer.toString(i) + "\n");
    }

    static void bwPrint(String s) throws IOException {
        bw.write(s);
    }

    static void bwPrint(int i) throws IOException {
        bw.write(i);
    }
}
