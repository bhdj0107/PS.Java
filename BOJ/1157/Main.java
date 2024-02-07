import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        // 초기화
        int charCnt[] = new int[(int)'z' - (int)'a' + 1];
        for (int i = 0; i < 26; i++) {
            charCnt[i] = 0;
        }

        // 카운팅
        String inp = br.readLine();
        for (int i = 0; i < inp.length(); i++) {
            int nowCharacter = (int)inp.charAt(i);
            if ('a' <= nowCharacter && nowCharacter <= 'z') {
                nowCharacter = nowCharacter - 'a';
            } else if ('A' <= nowCharacter && nowCharacter <= 'Z') {
                nowCharacter = nowCharacter - 'A';
            }
            charCnt[nowCharacter] += 1;
        }

        int maxIdx = -1;
        int maxValue = 0;
        int maxCnt = 0;

        for (int i = 0; i < 26; i++) {
            if (charCnt[i] > maxValue) {
                maxIdx = i;
                maxValue = charCnt[i];
                maxCnt = 1;
            } else if (charCnt[i] == maxValue) {
                maxCnt += 1;
            }
        }

        if (maxCnt == 1) {
            System.out.printf("%c", 'A' + maxIdx);
        } else {
            System.out.println("?");
        }

    }

    static int parseFromString(String str) {
        return Integer.parseInt(str);
    }
}
