import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int moneys[] = new int[N];

        for (int i = 0; i < N; i++) moneys[i] = Integer.parseInt(br.readLine());

        long minMoney = 1;
        for (int i = 0; i < N; i++) minMoney = Long.max(minMoney, (long)moneys[i]);
        minMoney -= 1;
        long maxMoney = 2147483648L;

        while (true) {
            long halfMoney = (minMoney + maxMoney) / 2;
            if (halfMoney == minMoney) break;
            int withdrawCnt = 1;
            long remainMoney = halfMoney;
            for (int i = 0; i < N; i++) {
                // 그날 사용할 금액이 남은 돈 보다 적은 경우
                if (moneys[i] <= remainMoney) {
                    remainMoney -= moneys[i];

                // 그날 사용할 금액이 남은 돈 보다 많은 경우
                } else if (moneys[i] > remainMoney) {
                    // 새로 출금하면 한번에 해결되는 경우
                    if (moneys[i] <= halfMoney) {
                        withdrawCnt += 1;
                        remainMoney = halfMoney - moneys[i];

                    // 여러번 더 출금해야 하는 경우
                    } else {
                        long additionalWithdrawCnt = moneys[i] / halfMoney;
                        long remainAfterWithdraw = moneys[i] % halfMoney;

                        withdrawCnt += additionalWithdrawCnt;
                        if (remainAfterWithdraw > 0) {
                            remainMoney = halfMoney - remainAfterWithdraw;
                            withdrawCnt += 1;
                        }
                    }
                }
            }

            if (withdrawCnt > M) minMoney = halfMoney;
            else maxMoney = halfMoney;
        }

        bw.write(maxMoney + "\n");
        bw.flush();
        bw.close();
    }

}