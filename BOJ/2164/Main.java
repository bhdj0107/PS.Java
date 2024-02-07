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
        int cardCnt = Integer.parseInt(br.readLine());
        Queue q = new Queue(500001);

        for (int i = 1; i < cardCnt + 1; i++) q.push(i);
        while (q.size() > 1){
            q.pop();
            q.push(q.pop());
        }
        bw.write(Integer.toString(q.pop()) + "\n");
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
