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
        Stack stk = new Stack(10001);
        int opCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < opCnt; i++) {
            String inp[] = br.readLine().split(" ");

            if (inp[0].equals("push")) {
                stk.push(Integer.parseInt(inp[1]));
            }
            else if (inp[0].equals("pop")) {
                bw.write(Integer.toString(stk.pop()) + "\n");
            }
            else if (inp[0].equals("size")) {
                bw.write(Integer.toString(stk.size()) + "\n");
            }
            else if (inp[0].equals("empty")) {
                bw.write(Integer.toString(stk.isEmpty()) + "\n");
            }
            else if (inp[0].equals("top")) {
                bw.write(Integer.toString(stk.top()) + "\n");
            }
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
