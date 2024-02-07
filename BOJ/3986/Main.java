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
        int inpCnt = Integer.parseInt(br.readLine());
        int goodWordCnt = 0;

        for (int loop = 0; loop < inpCnt; loop++) {
            Stack stk = new Stack(100001);
            String inp = br.readLine();
            int len = inp.length();
            stk.push(inp.charAt(0));
            for (int i = 1; i < len; i++) {
                char peek = stk.top();
                if (peek == inp.charAt(i)) stk.pop();
                else stk.push(inp.charAt(i));
            }
            goodWordCnt += (stk.isEmpty() == 1)?1:0;
        }
        bw.write(Integer.toString(goodWordCnt) + "\n");
        bw.flush();
        bw.close();
    }
}
class Stack {
    private char container[];
    private int startIdx = -1;
    private int maxSize = 0;
    private int currentItemsCnt = 0;

    Stack(int Size) {
        this.container = new char[Size];
        this.maxSize = Size;
    }

    void push(char X) {
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

    char pop() {
        if (this.isEmpty() == 1) {
            return '0';
        } else {
            char ans = this.container[this.startIdx];
            this.currentItemsCnt -= 1;
            this.startIdx = (this.startIdx - 1) % this.maxSize;
            return ans;
        }
    }

    char top() {
        if (this.isEmpty() == 1) {
            return '0';
        } else {
            return this.container[this.startIdx];
        }
    }
}
