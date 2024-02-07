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

        String Adrian = "ABC";
        String Bruno = "BABC";
        String Goran = "CCAABB";

        int N = Integer.parseInt(br.readLine());
        String Answer = br.readLine();

        int score[] = {0, 0, 0};

        for (int i = 0; i < N; i++) {
            // Adrian
            score[0] += (Answer.charAt(i) == Adrian.charAt(i % 3))?1:0;
            // Bruno
            score[1] += (Answer.charAt(i) == Bruno.charAt(i % 4))?1:0;
            // Goran
            score[2] += (Answer.charAt(i) == Goran.charAt(i % 6))?1:0;
        }

        int maxIdx = -1;
        int maxVal = -1;
        String names[] = {"Adrian", "Bruno", "Goran"};
        for (int i = 0; i < 3; i++) {
            if (maxVal < score[i]) {
                maxIdx = i;
                maxVal = score[i];
            }
        }

        int multiCnt = 0;
        int multiBest[] = {-1, -1, -1};
        for (int i = 0; i < 3; i++) {
            if (score[i] == maxVal) {
                multiBest[multiCnt] = i;
                multiCnt += 1;
            }
        }

        System.out.println(maxVal);
        for (int i = 0; i < 3; i++) {
            if (multiBest[i] != -1) {
                System.out.println(names[multiBest[i]]);
            }
        }
    }
}
