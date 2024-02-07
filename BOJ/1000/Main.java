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
        int a = Integer.parseInt(inp[0]);
        int b = Integer.parseInt(inp[1]);

        System.out.println(a + b);

    }
}

