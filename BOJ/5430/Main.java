import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main {
    static InputStreamReader reader = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(reader);

    static OutputStreamWriter writer = new OutputStreamWriter(System.out);
    static BufferedWriter bw = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String ops = br.readLine();
            int elementsCnt = Integer.parseInt(br.readLine());
            Deque dq = new Deque(elementsCnt + 1);
            String elementsStr = br.readLine();
            String elements[] = elementsStr.substring(1, elementsStr.length() - 1).split(",");

            boolean isReversed = false;

            for (int i = 0; i < elementsCnt; i++) {
                dq.pushBack(Integer.parseInt(elements[i]));
            }
            boolean errored = false;
            for (int i = 0; i < ops.length(); i++
            ) {
                if (ops.charAt(i) == 'R') isReversed = !isReversed;
                else {
                    if (dq.isEmpty() == 1) {
                        errored = true;
                        break;
                    } else {
                        if (isReversed) dq.popBack();
                        else dq.popFront();
                    }
                }
            }

            if (errored) bw.write("error\n");
            else {
                if (dq.size() == 0) bw.write("[]\n");
                else {
                    bw.write("[");
                    int dqSize = dq.size();
                    for (int i = 0; i < dqSize - 1; i++) {

                        bw.write(Integer.toString(isReversed?dq.popBack():dq.popFront()) + ",");
                    }
                    bw.write(Integer.toString(isReversed?dq.popBack():dq.popFront()) + "]\n");
                }
            }

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
