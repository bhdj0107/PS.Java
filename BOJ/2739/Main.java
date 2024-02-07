import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int inp = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            System.out.println(Integer.toString(inp) + " * " +  Integer.toString(i) + " = " + Integer.toString(i * inp));
        }

    }
}
