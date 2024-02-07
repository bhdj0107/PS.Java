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
        int tCaseCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < tCaseCnt; t++) {
            Queue q = new Queue(101);
            String inp[] = br.readLine().split(" ");
            int docCnt = Integer.parseInt(inp[0]);
            int targetDocNum = Integer.parseInt(inp[1]);

            int priorityList[] = new int[docCnt];
            priorityCounter pCounter = new priorityCounter();

            inp = br.readLine().split(" ");

            for (int i = 0; i < docCnt; i++) {
                q.push(i);
                int priority = Integer.parseInt(inp[i]);
                priorityList[i] = priority;
                pCounter.addCnt(priority);
            }
            int printCnt = 0;
            while (q.isEmpty() == 0) {
                int thisDocNum = q.pop();
                int thisPriority = priorityList[thisDocNum];
                int maxPriority = pCounter.getHighestPriority();

                if (thisPriority == maxPriority) {
                    // 프린트 됨
                    printCnt += 1;
                    pCounter.subCnt(thisPriority);
                    if (thisDocNum == targetDocNum) break;
                } else {
                    q.push(thisDocNum);
                }
            }

            bw.write(Integer.toString(printCnt) + "\n");
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

class priorityCounter {
    private int pList[] = new int[10];
    priorityCounter() {
        for (int i = 0; i < 10; i++) this.pList[i] = 0;
    }

    void addCnt(int priority) {
        this.pList[priority] += 1;
    }

    void subCnt(int priority) {
        this.pList[priority] -= 1;
    }

    int getHighestPriority() {
        for (int i = 9; i > 0; i--) {
            if (this.pList[i] > 0) return i;
        }
        return 0;
    }
}
