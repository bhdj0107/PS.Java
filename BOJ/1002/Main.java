import java.util.*;
import java.math.*;
import java.io.*;

class Turret{
    public int x;
    public int y;
    public int radius;
    Turret(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public int getDistPow(Turret t) {
        return (int)Math.pow(this.x - t.x, 2) + (int)Math.pow(this.y - t.y, 2);
    }

    public int getCrossPoints(Turret t) {
        Turret big;
        Turret small;

        
       if (this.radius > t.radius) {big = this; small = t;}
        else {big = t; small = this;}

        int bigMsmall = (int)Math.pow(big.radius, 2) - 2 * big.radius * small.radius + (int)Math.pow(small.radius, 2);
        int bigPsmall = (int)Math.pow(big.radius, 2) + 2 * big.radius * small.radius + (int)Math.pow(small.radius, 2);
        int distPow = big.getDistPow(small);
        if (distPow == 0 && big.radius == small.radius) return -1;

        // 접점이 하나인 경우
        if (distPow == bigPsmall) return 1;
        else if (bigMsmall == distPow) return 1;

        // 접점이 두개인 경우
        if (bigMsmall < distPow && distPow < bigPsmall) return 2;

        return 0;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            Turret t1 = new Turret(x1, y1, r1);

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            Turret t2 = new Turret(x2, y2, r2);

            bw.write(t1.getCrossPoints(t2) + "\n");
        }
        bw.flush();
        bw.close();
    }
}