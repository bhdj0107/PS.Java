import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(writer);

        int X = Integer.parseInt(br.readLine());

        double result = (-1. + Math.abs(Math.sqrt(1 + 8 * X))) / 2.;

        int denominator = (int)Math.ceil(result) - 1;
        int bottoms = ((denominator * denominator) + denominator) / 2;
        denominator += 1;
        int total = denominator + 1;
        int molecule = X - bottoms;

        // 분모 + 분자가 짝수 일 때는 분자가 줄어드는 방향
        if (total % 2 == 0) {
            System.out.print(total - molecule);
            System.out.print("/");
            System.out.println(molecule);
        // 홀수 일 때는 분모가 줄어드는 방향
        } else {
            System.out.print(molecule);
            System.out.print("/");
            System.out.println(total - molecule);
        }
    }
}
