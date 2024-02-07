import java.io.*;
import java.util.*;
class Point {
    public int x;
    public int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> al = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String inpStr = br.readLine();
            String inp[] = inpStr.split(" ");
            Point p = new Point(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
            al.add(p);
        }

        Collections.sort(al, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.x < b.x) return -1;
                else if (a.x > b.x) return 1;
                else {
                    if (a.y < b.y) return -1;
                    else return 1;
                }
            }
        });
        for (int i = 0; i < N; i++) bw.write(al.get(i).x + " " + al.get(i).y + "\n");
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
