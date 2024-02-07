import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int loopCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < loopCnt; i++) {
            String inpStr[] = br.readLine().split(" ");
            int inp[] = null;
            int numsCnt = parseFromString(inpStr[0]);

            inp = new int[numsCnt];
            for (int j = 0; j < numsCnt; j++) {
                inp[j] = parseFromString(inpStr[j + 1]);
            }

            int totalScore = 0;
            for (int j = 0; j < numsCnt; j++) {
                totalScore += inp[j];
            }
            float meanScore = (float)totalScore / numsCnt;

            int overPersonCnt = 0;
            for (int j = 0; j < numsCnt; j++) {
                if (inp[j] > meanScore) {
                    overPersonCnt += 1;
                }
            }

            float overPersonPerc = (float)overPersonCnt  * 100 / numsCnt;
            System.out.printf("%.3f"+"%%\n", overPersonPerc);

        }
    }

    static int parseFromString(String str) {
        return Integer.parseInt(str);
    }
}
