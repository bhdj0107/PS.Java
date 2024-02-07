import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int result = 1;
		int count[] = {0,0,0,0,0,0,0,0,0,0};
		Scanner inp = new Scanner(System.in);
		result = result * inp.nextInt();
		result = result * inp.nextInt();
		result = result * inp.nextInt();
		String a = String.valueOf(result);
		for (int i = 1; i < a.length() + 1; i++) {
			count[Integer.parseInt(a.substring(i-1,i))] += 1;
		}
		for (int b : count) {
			System.out.println(b);
		}
	}
}
