import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        while (true) {
            String inp = br.readLine();
            if (inp.equals("-1")) break;

            String nums[] = inp.split(" ");
            Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
            for (int i = 0; i < nums.length - 1; i++) {
                hm.put(Integer.parseInt(nums[i]), true);
            }
            int cnt = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                cnt += hm.containsKey(Integer.parseInt(nums[i]) * 2)?1:0;
            }
            System.out.println(cnt);
        }

    }
}
