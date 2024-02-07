import java.io.IOException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.io.BufferedWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String dayName[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        String inp[] = br.readLine().split(" ");
        int M = Integer.parseInt(inp[0]);
        int D = Integer.parseInt(inp[1]);

        int totalDates = 0;
        for (int i = 0; i < M - 1; i++) {
            totalDates += monthDays[i];
        }

        totalDates += D - 1;
        totalDates = totalDates % 7;
        System.out.println(dayName[totalDates]);
    }
}
