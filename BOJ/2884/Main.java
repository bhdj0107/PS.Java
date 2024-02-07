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

        int H = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);

        H += 24;

        if (M < 45) {
            H -= 1;
            M += 15;
        } else {
            M -= 45;
        }

        H = H % 24;
        System.out.print(H);
        System.out.print(" ");
        System.out.println(M);


    }
}

