import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException{
        String inp = br.readLine();
        int inps[] = new int[inp.length()];
        for (int i = 0; i < inps.length; i++) {
            inps[i] = Integer.parseInt(inp.substring(i, i+1));
        }
        Arrays.sort(inps);
        for (int i = inps.length - 1; i > -1; i--) bw.write(Integer.toString(inps[i]));
        bw.write("\n");
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
