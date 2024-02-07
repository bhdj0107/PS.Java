import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String tStr[] = br.readLine().split(" ");
            int candiesCnt = Integer.parseInt(tStr[0]);
            int boxesCnt = Integer.parseInt(tStr[1]);
            ArrayList<Integer> boxes = new ArrayList<>();
            for (int i = 0; i < boxesCnt; i++) {
                tStr = br.readLine().split(" ");
                int R = Integer.parseInt(tStr[0]);
                int C = Integer.parseInt(tStr[1]);
                boxes.add(R * C);
            }

            Collections.sort(boxes);
            int usedBoxCnt = 0;
            for (int i = boxesCnt - 1; i > -1; i--) {
                if (candiesCnt <= 0) break;
                usedBoxCnt += 1;
                candiesCnt -= boxes.get(i);

            }
            bw.write(usedBoxCnt + "\n");
        }
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
