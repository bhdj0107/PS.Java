import java.io.IOException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;

import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        ArrayList<Integer> inpList = new ArrayList<>();
        ArrayList<Boolean> highlowList = new ArrayList<>();

        int counter = 0;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            String inp = br.readLine();

            if (inp.equals("too high")) {
                counter += 1;
                inpList.add(N);
                highlowList.add(true);
            } else if (inp.equals("too low")) {
                counter += 1;
                inpList.add(N);
                highlowList.add(false);
            } else {
                String ans = "Stan may be honest";
                for (int i = 0; i < counter; i++) {
                    int num = inpList.get(i);
                    boolean flag = highlowList.get(i);
                    if (flag) {
                        if (num <= N) {
                            ans = "Stan is dishonest";
                            break;
                        }
                    } else {
                        if (num >= N) {
                            ans = "Stan is dishonest";
                            break;
                        }
                    }
                }
                System.out.println(ans);

                inpList.clear();
                highlowList.clear();
                counter = 0;
            }
        }
    }
}
