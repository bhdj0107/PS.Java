import java.io.*;
import java.util.*;
class Meet {
    public int s;
    public int e;
    Meet(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public String toString() {
        return "(" + this.s + ", " + this.e + ")";
    }
}
class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        ArrayList<Meet> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String tStr[] = br.readLine().split(" ");
            int s = Integer.parseInt(tStr[0]);
            int e = Integer.parseInt(tStr[1]);
            al.add(new Meet(s, e));
        }
        Collections.sort(al, new Comparator<Meet>() {
            @Override
            public int compare(Meet a, Meet b) {
                if (a.e < b.e) return -1;
                else if (a.e > b.e) return 1;
                else {
                    if (a.s < b.s) return -1;
                    else return 1;
                }

            }
        });
        int last = al.get(0).e;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            Meet now = al.get(i);
            if (last <= now.s) {
                last = now.e;
                cnt += 1;
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
