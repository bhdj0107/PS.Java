import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        // float
        float fl = getIntArrMean(nums);
        bw.write((int)Math.round(fl) + "\n");
        bw.write(getIntArrMedian(nums) + "\n");
        bw.write(getIntArrSecondShown(nums) + "\n");
        bw.write(getIntArrRange(nums) + "\n");
        bw.flush();
        bw.close();
    }

    public float getIntArrMean(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        return (float)sum / (float)arr.length;
    }

    public int getIntArrMedian(int[] arr) {
        return arr[(arr.length + 1) / 2 - 1];
    }

    public int getIntArrSecondShown(int[] arr) {
        ArrayList<Integer> numList = new ArrayList<>();
        HashMap<Integer, Integer> numCnt = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (numCnt.containsKey(arr[i])) {
                numCnt.put(arr[i], numCnt.get(arr[i]) + 1);
            } else {
                numCnt.put(arr[i], 1);
                numList.add(arr[i]);
            }
        }

        int maxCnt = -1;
        ArrayList<Integer> maxNumList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) maxCnt = Integer.max(maxCnt, numCnt.get(numList.get(i)));

        for (int i = 0; i < numList.size(); i++) {
            if (numCnt.get(numList.get(i)) == maxCnt) maxNumList.add(numList.get(i));
        }

        Collections.sort(maxNumList);
        if (maxNumList.size() > 1) {
            return maxNumList.get(1);
        } else {
            return maxNumList.get(0);
        }
    }

    public int getIntArrRange(int[] arr) {
        return arr[arr.length - 1] - arr[0];
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
