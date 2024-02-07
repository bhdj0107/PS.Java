import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int N = Integer.parseInt(br.readLine());

        String firstLineStr = br.readLine();
        char firstLine[] = new char[firstLineStr.length()];
        String nextLines[] = new String[N - 1];

        for (int i = 0; i < N - 1; i++) {
            nextLines[i] = br.readLine();
        }

        for (int i = 0; i < firstLineStr.length(); i++) {
            firstLine[i] = firstLineStr.charAt(i);
        }

        for (int i = 0; i < N - 1; i++) {
            String thisLineStr = nextLines[i];
            for (int j = 0; j < firstLine.length; j++) {
                char thisChr = thisLineStr.charAt(j);

                if (firstLine[j] != thisChr) {
                    firstLine[j] = '?';
                }
            }
        }

        System.out.println(String.copyValueOf(firstLine));
    }

}
