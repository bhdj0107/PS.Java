import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        String inp[] = br.readLine().replace('+', ' ').split("-");
        int N = SumOfString(inp[0]);
        for (int i = 1; i < inp.length; i++) N -= SumOfString(inp[i]);
        bw.write(N + "\n");
        bw.flush();
        bw.close();
    }

    public int SumOfString(String str) {
        String[] splt = str.split(" ");
        int ret = 0;
        for (int i = 0; i < splt.length; i++) ret += Integer.parseInt(splt[i]);
        return ret;
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
