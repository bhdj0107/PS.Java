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
        int N = Integer.parseInt(br.readLine());
        Deque dq = new Deque(N + 1);

        String inp[] = br.readLine().split(" ");

        for (int i = N - 1; i > -1; i--) {
            if (inp[i].equals("1")) {
                dq.pushFront(N - i);
            }
            else if (inp[i].equals("2")) {
                int t = dq.popFront();
                dq.pushFront(N - i);
                dq.pushFront(t);
            }
            else if (inp[i].equals("3")) {
                dq.pushBack(N - i);
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(Integer.toString(dq.popFront()) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
class Deque {
    private int container[];
    private int maxSize = 0;

    private int startIdx = 0;
    private int endIdx = 0;
    private int currentItemsCnt = 0;

    Deque(int size) {
        this.maxSize = size;
        this.container = new int[size];
    }

    void pushFront(int X) {
        if (this.isEmpty() == 1) {
            this.startIdx = 0; this.endIdx = 0;
            this.container[this.startIdx] = X;
            this.startIdx = (this.startIdx - 1 + this.maxSize) % this.maxSize;
            this.endIdx = (this.endIdx + 1 + this.maxSize) % this.maxSize;
        } else {
            this.container[this.startIdx] = X;
            this.startIdx = (this.startIdx - 1 + this.maxSize) % this.maxSize;
        }
        this.currentItemsCnt += 1;
    }

    void pushBack(int X) {
        if (this.isEmpty() == 1) {
            this.startIdx = 0; this.endIdx = 0;
            this.container[this.endIdx] = X;
            this.startIdx = (this.startIdx - 1 + this.maxSize) % this.maxSize;
            this.endIdx = (this.endIdx + 1 + this.maxSize) % this.maxSize;
        } else {
            this.container[this.endIdx] = X;
            this.endIdx = (this.endIdx + 1 + this.maxSize) % this.maxSize;
        }
        this.currentItemsCnt += 1;
    }

    int popFront() {
        if (this.isEmpty() == 1) return -1;
        this.currentItemsCnt -= 1;
        this.startIdx = (this.startIdx + 1 + this.maxSize) % this.maxSize;
        return this.container[this.startIdx];
    }

    int popBack() {
        if (this.isEmpty() == 1) return -1;
        this.currentItemsCnt -= 1;
        this.endIdx = (this.endIdx - 1 + this.maxSize) % this.maxSize;
        return this.container[this.endIdx];
    }

    int size() {
        return this.currentItemsCnt;
    }

    int isEmpty() {
        return (this.currentItemsCnt == 0)?1:0;
    }

    int front() {
        if (this.isEmpty() == 1) return -1;
        return this.container[((this.startIdx + 1 + this.maxSize) % this.maxSize)];
    }

    int back() {
        if (this.isEmpty() == 1) return -1;
        return this.container[((this.endIdx - 1 + this.maxSize) % this.maxSize)];
    }
}
