import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        int inp[] = null;
        inp = new int[9];
        for (int i = 0; i < 9; i++) {
            inp[i] = Integer.parseInt(br.readLine());
        }

        int maxIdx = -1;
        int maxValue = -1;
        for (int i = 0; i < 9; i++) {
            if (inp[i] > maxValue) {
                maxIdx = i;
                maxValue = inp[i];
            }
        }

        System.out.println(maxValue);
        System.out.println(maxIdx + 1);
    }
}
