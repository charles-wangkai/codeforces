import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		System.out.println(solve(v));

		sc.close();
	}

	static int solve(int v) {
		return (v == 2) ? 2 : 1;
	}
}
