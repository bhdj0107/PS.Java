import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;
import java.lang.Math;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    static Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(hanoiCnt(N)) + "\n");

        hanoi(N, 1, 3);
        bw.flush();
        bw.close();
    }

    static int hanoiCnt(int N) {
        if (N == 1) return 1;
        if (hm.containsKey(N)) return hm.get(N);
        else {
            int value = hanoiCnt(N - 1) * 2 + 1;
            hm.put(N, value);
            return value;
        }
    }

    static void hanoi(int blockNum, int startPos, int targetPos) throws IOException{
        // 로직
        // 빈 공간 , 현재 내 위치, 목표 위치 가 있을 때
        // 내 위에 있는 애들은 빈 공간으로 옮기고
        // 나를 목표위치로 옮기고
        // 빈 공간에 뒀던 애들을 다시 목표 위치로 옮기기

        int blankPos = 6 - startPos - targetPos;

        if (blockNum != 1) {
            // 위에 친구들 옮기고
            hanoi(blockNum - 1, startPos, blankPos);

            // 나 옮기고
            String t = "";
            t += Integer.toString(startPos) + " ";
            t += Integer.toString(targetPos);
            bw.write(t + "\n");

            // 위에 애들 얹기
            hanoi(blockNum - 1, blankPos, targetPos);
        } else {
            // 내가 1이면 나만 옮기기
            String t = "";
            t += Integer.toString(startPos) + " ";
            t += Integer.toString(targetPos);
            bw.write(t + "\n");
        }
    }
}
