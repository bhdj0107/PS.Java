import java.io.*;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long gcdSum = 0;
            String inp[] = br.readLine().split(" ");
            int eleCnt = Integer.parseInt(inp[0]);
            int elements[] = new int[eleCnt];
            for (int i = 0; i < eleCnt; i++) elements[i] = Integer.parseInt(inp[1 + i]);
            for (int i = 0; i < eleCnt - 1; i++) {
                for (int j = i + 1; j < eleCnt; j++) {
                    gcdSum += GCD(elements[i], elements[j]);
                }
            }
            bw.write(Long.toString(gcdSum) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
}
