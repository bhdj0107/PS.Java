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
        String inpStr = Integer.toString(inp);

        int cnt = 0;
        String befStr = "";
        if (inp < 10) befStr = "0" + Integer.toString(inp);
        else befStr = Integer.toString(inp);
        while (true) {
            cnt += 1;
            String aftStr = "";
            int a = Integer.parseInt(Character.toString(befStr.charAt(0)));
            int b = Integer.parseInt(Character.toString(befStr.charAt(1)));
            aftStr = Integer.toString(a + b);
            if (Integer.parseInt(aftStr) < 10) aftStr = "0" + aftStr;
            String newStr = Character.toString(befStr.charAt(1)) + Character.toString(aftStr.charAt(1));

            if (Integer.parseInt(newStr) == Integer.parseInt(inpStr)) {
                break;
            }
            else {
                befStr = newStr;
            }
        }

        System.out.println(cnt);

    }
}
;
