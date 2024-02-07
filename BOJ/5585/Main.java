import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] money = {500, 100, 50, 10, 5, 1};
        for (int i = 0; i < money.length; i++) {
            int divCnt = N / money[i];
            if (divCnt > 0) {
                N -= money[i] * divCnt;
                cnt += divCnt;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
