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

        int N = Integer.parseInt(br.readLine());
        int ans = -1;
        for (int i = 0; i < 1000001; i++) {
            if (i > N) break;
            int num = i;
            String iString = Integer.toString(i);
            for (int j = 0; j < iString.length(); j++) {
                num += Integer.parseInt(iString.substring(j, j + 1));
            }
            if (num == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
