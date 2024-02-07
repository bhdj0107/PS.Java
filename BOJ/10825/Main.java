import java.io.*;
import java.util.*;
class Person {
    public String name;
    public int ko;
    public int en;
    public int math;
    Person(String name, int ko, int en, int math) {
        this.name = name;
        this.ko = ko;
        this.en = en;
        this.math = math;
    }
    public String toString() {
        return "(" + this.name + ", " + this.ko + ", " + this.en + ", " + this.math + ")";
    }
}
class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String inp[] = br.readLine().split(" ");
            int ko = Integer.parseInt(inp[1]);
            int en = Integer.parseInt(inp[2]);
            int math = Integer.parseInt(inp[3]);
            al.add(new Person(inp[0], ko, en, math));
        }

        Collections.sort(al, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                if (a.ko > b.ko) return -1;
                else if (a.ko < b.ko) return 1;
                else {
                    if (a.en < b.en) return -1;
                    else if (a.en > b.en) return 1;
                    else {
                        if (a.math > b.math) return -1;
                        else if (a.math < b.math) return 1;
                        else {
                            return a.name.compareTo(b.name);
                        }
                    }
                }
            }
        });
        for (int i = 0; i < N; i++) bw.write(al.get(i).name + "\n");
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String argv[]) throws IOException{
        Solution sol = new Solution();
        sol.solution();
    }
}
