import java.util.*;
import java.math.*;
import java.io.*;

class Town {
    public long position;
    public long population;

    Town(long position, long population) {
        this.position = position;
        this.population = population;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        ArrayList<Town> ar = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ar.add(new Town(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        ar.sort(new Comparator<Town>() {
            @Override
            public int compare(Town a, Town b) {
                if (a.position < b.position) return -1;
                else return 1;
            }
        });

        BigInteger leftDistance[] = new BigInteger[N];
        Arrays.fill(leftDistance, new BigInteger("0"));
        BigInteger deltaDistance = new BigInteger("0");
        for (int i = 1; i < N; i++) {
            deltaDistance = deltaDistance.add(new BigInteger(Long.toString(ar.get(i - 1).population)));
            long diff = ar.get(i).position - ar.get(i - 1).position;
            leftDistance[i] = leftDistance[i - 1].add(deltaDistance.multiply(new BigInteger(Long.toString(diff))));
        }

        BigInteger rightDistance[] = new BigInteger[N];
        Arrays.fill(rightDistance, new BigInteger("0"));
        deltaDistance = new BigInteger("0");
        for (int i = N - 2; i > -1; i--) {
            deltaDistance = deltaDistance.add(new BigInteger(Long.toString(ar.get(i + 1).population)));
            long diff = ar.get(i + 1).position - ar.get(i).position;
            rightDistance[i] = rightDistance[i + 1].add(deltaDistance.multiply(new BigInteger(Long.toString(diff))));
        }

        long ans = ar.get(0).position;
        BigInteger minimum = leftDistance[0].add(rightDistance[0]);
        long minPopulation = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            BigInteger sumDist = leftDistance[i].add(rightDistance[i]);
            if (sumDist.compareTo(minimum) == -1) {
                minimum = sumDist;
                Town t = ar.get(i);
                ans = t.position;
                minPopulation = t.population;
            }
        }

        if (minPopulation == 0 && minimum.compareTo(new BigInteger("0")) == 0) {
            bw.write(-1000000000 + "\n");
        } else {
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}