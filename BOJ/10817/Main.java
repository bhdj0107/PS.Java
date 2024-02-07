import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        String inp[] = br.readLine().split(" ");

        int num[] = { Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]) };

        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (num[i] < num[j]) {
                    int a = num[i];
                    int b = num[j];
                    num[i] = b;
                    num[j] = a;
                }
            }
        }

        System.out.println(num[1]);

    }
}

