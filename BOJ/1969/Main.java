import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        String inp[] = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]), M = Integer.parseInt(inp[1]);

        String strs[] = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        int cnts[][] = new int[M][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                cnts[i][j] = 0;
            }
        }
        Map<Character, Integer> dna2index = new HashMap<Character, Integer>();
        dna2index.put('A', 0);
        dna2index.put('C', 1);
        dna2index.put('G', 2);
        dna2index.put('T', 3);

        Map<Integer, String> index2dna = new HashMap<Integer, String>();
        index2dna.put(0, "A");
        index2dna.put(1, "C");
        index2dna.put(2, "G");
        index2dna.put(3, "T");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnts[j][dna2index.get(strs[i].charAt(j))] += 1;
            }
        }

        int maxIndexes[] = new int[M];
        int maxIdxCnt[] = new int[M];
        int hamming = N * M;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                if (maxIdxCnt[i] < cnts[i][j]) {
                    maxIndexes[i] = j;
                    maxIdxCnt[i] = cnts[i][j];
                }
            }
        }
        for (int i = 0; i < M; i++) {
            bw.write(index2dna.get(maxIndexes[i]));
            hamming -= maxIdxCnt[i];
        }

        bw.write("\n");
        bw.write(Integer.toString(hamming));
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}
