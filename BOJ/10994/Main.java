import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;
import java.lang.Math;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    static int N;
    static char field[][];
    static String ans[];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new char[4 * N - 3][4 * N - 3];
        ans = new String[4 * N - 3];
        for (int i = 0; i < 4 * N - 3; i++) {
            for (int j = 0; j < 4 * N - 3; j++) {
                field[i][j] = ' ';
            }
        }
        drawStars(0, N);
        updateField();

        for (int i = 0; i < 4 * N - 3; i++) {
            bw.write(ans[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void updateField() {
        for (int i = 0; i < 4 * N - 3; i++) {
            ans[i] = String.copyValueOf(field[i]);
        }
    }

    static void drawStars(int border, int A) {
        if (A == 1) {
            field[border][border] = '*';
            updateField();
        } else {
            for (int i = 0; i < 2 * A - 1; i++) {
                int leftTop = border;
                int rightBottom = 4 * N - 4 - border;

                // 1사분면
                field[leftTop][rightBottom - i] = '*';
                field[leftTop + i][rightBottom] = '*';

                // 2사분면
                field[leftTop + i][leftTop] = '*';
                field[leftTop][leftTop + i] = '*';

                // 3사분면
                field[rightBottom - i][leftTop] = '*';
                field[rightBottom][leftTop + i] = '*';

                // 4사분면
                field[rightBottom - i][rightBottom] = '*';
                field[rightBottom][rightBottom - i] = '*';

                updateField();
            }

            drawStars(border + 2, A - 1);
        }
    }
}
