import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < N; i++) al.add(Integer.parseInt(br.readLine()));
        Collections.sort(al);
        for (int i = 0; i < N; i++) bw.write(al.get(i) + "\n");
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
