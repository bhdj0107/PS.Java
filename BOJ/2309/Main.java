import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;


public class Main {
    static int heights[] = new int[9];
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] > heights[j]) {
                    int temp = heights[j];
                    heights[j] = heights[i];
                    heights[i] = temp;
                }
            }
        }

        int ans_a = -1, ans_b = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                boolean chk = chkHeight(i, j);
                if (chk) {
                    ans_a = i;
                    ans_b = j;
                    break;
                }
            }
            if (ans_a != -1 && ans_b != -1) break;
        }

        for (int i = 0; i < 9; i++) {
            if (i == ans_a || i == ans_b) continue;
            System.out.println(heights[i]);
        }
    }

    public static boolean chkHeight(int a, int b) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (i == a || i == b) continue;
            sum += heights[i];
        }
        return (boolean)(sum == 100);
    }
}
