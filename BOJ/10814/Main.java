import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        String inps[][] = new String[N][3];
        for (int i = 0; i < N; i++) {
            String inpStr = br.readLine();
            String inp[] = inpStr.split(" ");
            inps[i][0] = inp[0];
            inps[i][1] = inp[1];
            inps[i][2] = Integer.toString(i);
        }
        quickSort(inps, 0, N - 1);
        for (int i = 0; i < N; i++) bw.write(inps[i][0] + " " + inps[i][1] + "\n");
        bw.flush();
        bw.close();
    }

    public void quickSort(String[][] arr, int left, int right) {
        if (right - left + 1 <= 1) return;
        String[] pivot = arr[left];
        int sortLeft = left + 1;
        int sortRight = right;
        while (true) {
            if (sortLeft > sortRight) break;
            String leftStr[] = arr[sortLeft];
            if (strMin(leftStr, pivot) == -1) {
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

    public int strMin(String[] aA, String[] bA) {
        String a = aA[0] + " " + aA[1];
        String b = bA[0] + " " + bA[1];
        if (Integer.parseInt(aA[0]) < Integer.parseInt(bA[0])) return -1;
        else if (Integer.parseInt(bA[0]) < Integer.parseInt(aA[0])) return 1;
        else {
            return (Integer.parseInt(aA[2]) < Integer.parseInt(bA[2]))?-1:1;
        }
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
