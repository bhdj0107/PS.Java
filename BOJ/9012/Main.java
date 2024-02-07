import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;
import java.lang.Math;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);
    public static void main(String[] args) throws IOException {
        int vpsCnt = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < vpsCnt; loop++) {
            boolean flag = true;
            String inp = br.readLine();
            int len = inp.length();
            Stack stk = new Stack(100);
            for (int i = 0; i < len; i++) {
                char thisChr = inp.charAt(i);
                if (thisChr == '(') stk.push(thisChr);
                else {
                    if (stk.isEmpty() == 1) {
                        flag = false;
                    } else {
                        stk.pop();
                    }
                }
            }
            bw.write((flag && (stk.isEmpty() == 1))?"YES\n":"NO\n");
        }
        bw.flush();
        bw.close();
    }
}
class Stack {
    private int container[];
    private int startIdx = -1;
    private int maxSize = 0;
    private int currentItemsCnt = 0;

    Stack(int Size) {
        this.container = new int[Size];
        this.maxSize = Size;
    }

    void push(int X) {
        this.container[this.currentItemsCnt] = X;
        this.startIdx = (this.startIdx + 1) % this.maxSize;
        this.currentItemsCnt += 1;
    }

    int isEmpty() {
        return (this.currentItemsCnt == 0)?1:0;
    }

    int size() {
        return this.currentItemsCnt;
    }

    int pop() {
        if (this.isEmpty() == 1) {
            return -1;
        } else {
            int ans = this.container[this.startIdx];
            this.currentItemsCnt -= 1;
            this.startIdx = (this.startIdx - 1) % this.maxSize;
            return ans;
        }
    }

    int top() {
        if (this.isEmpty() == 1) {
            return -1;
        } else {
            return this.container[this.startIdx];
        }
    }
}
