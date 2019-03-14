import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		Operation[] operations = new Operation[m];
		for (int i = 0; i < operations.length; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			char c1 = sc.next().charAt(0);
			char c2 = sc.next().charAt(0);

			operations[i] = new Operation(l, r, c1, c2);
		}
		System.out.println(solve(s, operations));

		sc.close();
	}

	static String solve(String s, Operation[] operations) {
		StringBuilder result = new StringBuilder(s);
		for (Operation operation : operations) {
			for (int i = operation.l - 1; i <= operation.r - 1; i++) {
				if (result.charAt(i) == operation.c1) {
					result.setCharAt(i, operation.c2);
				}
			}
		}
		return result.toString();
	}
}

class Operation {
	int l;
	int r;
	char c1;
	char c2;

	Operation(int l, int r, char c1, char c2) {
		this.l = l;
		this.r = r;
		this.c1 = c1;
		this.c2 = c2;
	}
}