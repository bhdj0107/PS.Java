import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        String[] inps = br.readLine().split(" ");
        int twos = 0;
        int ones = 0;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(inps[i]);
            twos += now / 2;
            ones += now % 2;
        }
        int ans = twos - ones;
        if (ans % 3 == 0 && ans >= 0) bw.write("YES\n");
        else bw.write("NO\n");
        bw.flush();
        bw.close();
    }
}