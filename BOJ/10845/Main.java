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
        int opCnt = Integer.parseInt(br.readLine());
        Queue q = new Queue(10001);

        for (int i = 0; i < opCnt; i++) {
            String inp[] = br.readLine().split(" ");
            if (inp[0].equals("push")) {
                q.push(Integer.parseInt(inp[1]));
            }
            else if (inp[0].equals("pop")) {
                bw.write(Integer.toString(q.pop()) + "\n");
            }
            else if (inp[0].equals("size")) {
                bw.write(Integer.toString(q.size()) + "\n");
            }
            else if (inp[0].equals("empty")) {
                bw.write(Integer.toString(q.isEmpty()) + "\n");
            }
            else if (inp[0].equals("front")) {
                bw.write(Integer.toString(q.front()) + "\n");
            }
            else if (inp[0].equals("back")) {
                bw.write(Integer.toString(q.back()) + "\n");
            }

        }
        bw.flush();
        bw.close();
    }
}
class Queue {
    private int container[];
    private int maxSize = 0;

    private int startIdx = 0;
    private int endIdx = 0;
    private int currentItemsCnt = 0;

    Queue(int size) {
        this.maxSize = size;
        this.container = new int[size];
    }

    void push(int X) {
        this.container[this.endIdx] = X;
        this.endIdx = (this.endIdx + 1) % this.maxSize;
        this.currentItemsCnt += 1;
    }

    int isEmpty() {
        return (currentItemsCnt == 0)?1:0;
    }

    int size() {
        return currentItemsCnt;
    }

    int pop() {
        if (this.isEmpty() == 1) {
            return -1;
        } else {
            int popped = this.container[this.startIdx];
            this.startIdx = (this.startIdx + 1) % this.maxSize;
            this.currentItemsCnt -= 1;
            return popped;
        }
    }

    int front() {
        if (this.isEmpty() == 1) return -1;
        else return this.container[this.startIdx];
    }

    int back() {
        if (this.isEmpty() == 1) return -1;
        else {
            int newEnd = (this.endIdx - 1) % this.maxSize;
            return this.container[newEnd];
        }
    }
}
