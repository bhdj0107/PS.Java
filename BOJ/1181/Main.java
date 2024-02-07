import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    HashSet<String> hs = new HashSet<>();

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        String inps[] = new String[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String inp = br.readLine();
            if (hs.contains(inp)) continue;
            hs.add(inp);
            inps[cnt] = inp;
            cnt += 1;
        }
        quickSort(inps, 0, cnt - 1);
        for (int i = 0; i < cnt; i++) bw.write(inps[i] + "\n");
        bw.flush();
        bw.close();
    }

    public void quickSort(String[] arr, int left, int right) {
        if (right - left + 1 <= 1) return;
        String pivot = arr[left];
        int sortLeft = left + 1;
        int sortRight = right;
        while (true) {
            if (sortLeft > sortRight) break;
            String leftStr = arr[sortLeft];
            if (strMin(leftStr, pivot).equals(leftStr)) {
                sortLeft += 1;
            } else {
                arr[sortLeft] = arr[sortRight];
                arr[sortRight] = leftStr;
                sortRight -= 1;
            }
        }
        arr[left] = arr[sortLeft - 1];
        arr[sortLeft - 1] = pivot;

        quickSort(arr, left, sortLeft - 2);
        quickSort(arr, sortRight + 1, right);
    }

    public String strMin(String a, String b) {
        if (a.length() < b.length()) return a;
        else if (b.length() < a.length()) return b;
        else {
            String[] ar = new String[2];
            ar[0] = a;
            ar[1] = b;
            Arrays.sort(ar);
            return ar[0];
        }
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
